package com.zerobase.api.loan.request

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.zerobase.api.loan.encrypt.Encryptor
import com.zerobase.domain.domain.UserInfo
import com.zerobase.domain.repository.UserInfoRepository
import io.mockk.every
import io.mockk.spyk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@ExtendWith(MockitoExtension::class)
internal class LoanRequestControllerTest {
    private lateinit var mockMvc: MockMvc

    private lateinit var loanRequestController: LoanRequestController

    private lateinit var keyGenerator: KeyGenerator
    private lateinit var encryptor: Encryptor

    private val userInfoRepository: UserInfoRepository= spyk()
    private lateinit var mapper: ObjectMapper

    private lateinit var loanRequestServiceImpl: LoanRequestServiceImpl

    companion object {
        private const val baseUrl = "/fintech/api/v1"
    }

    @BeforeEach
    fun init() {
        keyGenerator = KeyGenerator()
        encryptor = Encryptor()

        loanRequestServiceImpl = LoanRequestServiceImpl(
                keyGenerator, encryptor, userInfoRepository
        )
        loanRequestController = LoanRequestController(loanRequestServiceImpl)
        mockMvc = MockMvcBuilders.standaloneSetup(loanRequestController).build()
        mapper = ObjectMapper().registerModule(KotlinModule.Builder().build())
    }

        @Test
        @DisplayName("대출 심사 요청 API 정상작동 확인")
        fun test() {
            val loanRequestInfoDto: LoanRequestDto.LoanRequestInputDto =
                    LoanRequestDto.LoanRequestInputDto(
                            userName = "TEST",
                            userIncomeAmount = 10000,
                            userRegistrationNumber = "000101-1234567"
                    )

            every { userInfoRepository.save(any()) } returns UserInfo("", "", "", 1)

            mockMvc.post(
                    "$baseUrl/request"
            ) {
                contentType = MediaType.APPLICATION_JSON
                accept = MediaType.APPLICATION_JSON
                content = mapper.writeValueAsString(loanRequestInfoDto)
            }.andExpect {
                status { isOk() }
            }
        }
}