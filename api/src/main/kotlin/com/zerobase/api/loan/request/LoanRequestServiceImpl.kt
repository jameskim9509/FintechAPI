package com.zerobase.api.loan.request

import com.zerobase.api.loan.encrypt.Encryptor
import com.zerobase.domain.domain.UserInfo
import com.zerobase.domain.repository.UserInfoRepository
import com.zerobase.kafka.enum.KafkaTopic
import com.zerobase.kafka.producer.LoanRequestSender
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class LoanRequestServiceImpl(
        private val generator: KeyGenerator,
        private val encryptor: Encryptor,
        private val userInfoRepository: UserInfoRepository,
        private val loanRequestSender: LoanRequestSender
): LoanRequestService {
    override fun loanRequestMain(
            loanRequestDto: LoanRequestDto.LoanRequestInputDto
    ): LoanRequestDto.LoanRequestOutputDto {
        val userKey = generator.generate()
        val encryptedRegStr = encryptor.encryptString(loanRequestDto.userRegistrationNumber)

        loanRequestDto.userRegistrationNumber = encryptedRegStr

        val userInfoDto = loanRequestDto.toUserInfoDto(userKey)

        saveUserInfo(userInfoDto)

        loanRequestReview(userInfoDto);

        return LoanRequestDto.LoanRequestOutputDto(userKey)
    }

    private fun LoanRequestDto.LoanRequestInputDto.toUserInfoDto(userKey: String): UserInfoDto =
            UserInfoDto(userKey, userName, userRegistrationNumber, userIncomeAmount)

    override fun saveUserInfo(userInfoDto: UserInfoDto): UserInfo =
            userInfoRepository.save(userInfoDto.toEntity());

    override fun loanRequestReview(userInfo: UserInfoDto) {
        loanRequestSender.sendMessage(
                KafkaTopic.LOAN_REQUEST,
                userInfo.toLoanRequestKafkaDto()
        )
    }

    private fun UserInfoDto.toLoanRequestKafkaDto() =
            com.zerobase.kafka.dto.LoanRequestDto(userKey, userName, userIncomeAmount, userRegistrationNumber)
}