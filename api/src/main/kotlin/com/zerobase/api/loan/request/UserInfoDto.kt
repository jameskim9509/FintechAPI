package com.zerobase.api.loan.request

import com.zerobase.domain.domain.UserInfo

data class UserInfoDto(
        val userKey: String,
        val userName: String,
        val userRegistrationNumber: String,
        val userIncomeAmount: Long
) {
    fun toEntity(): UserInfo =
        UserInfo(
                userKey = this.userKey,
                userName = this.userName,
                userRegistrationNumber = this.userRegistrationNumber,
                userIncomeAmount = this.userIncomeAmount
        )
}