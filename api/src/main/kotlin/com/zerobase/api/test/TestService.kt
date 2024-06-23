package com.zerobase.api.test

import com.zerobase.api.exception.CustomErrorCode
import com.zerobase.api.exception.CustomException
import com.zerobase.domain.domain.UserInfo
import com.zerobase.domain.repository.UserInfoRepository
import org.springframework.stereotype.Service

@Service
class TestService (
    private val userInfoRepository : UserInfoRepository
)
{
    fun testGetService(userKey: String) = userInfoRepository.findByUserKey(userKey)?.toDto()
            ?: throw CustomException(CustomErrorCode.USER_KEY_NOT_FOUND)

    private fun UserInfo.toDto() = TestDto.UserInfoDto(userKey, userRegistrationNumber, userName, userIncomeAmount)
}