package com.zerobase.api.test

import com.zerobase.domain.domain.UserInfo
import com.zerobase.domain.repository.UserInfoRepository
import org.springframework.stereotype.Service

@Service
class TestService (
    private val userInfoRepository : UserInfoRepository
)
{
    fun testGetService(userKey: String) = userInfoRepository.findByUserKey(userKey)?.toDto()
            ?: throw RuntimeException("UserKey Not Found")

    private fun UserInfo.toDto() = TestDto.UserInfoDto(userKey, userRegistrationNumber, userName, userIncomeAmount)
}