package com.zerobase.api.loan.request

import com.zerobase.domain.domain.UserInfo

interface LoanRequestService {
    fun loanRequestMain(
        loanRequestDto: LoanRequestDto.LoanRequestInputDto
    ): LoanRequestDto.LoanRequestOutputDto

    fun saveUserInfo(
        userInfoDto: UserInfoDto
    ): UserInfo

    fun loanRequestReview(userInfo: UserInfoDto)
}