package com.zerobase.api.loan.request

class LoanRequestDto {
    data class LoanRequestInputDto(
            val userName: String,
            val userIncomeAmount: Long,
            var userRegistrationNumber: String
    ){
    }

    data class LoanRequestOutputDto(
            val userKey: String
    )
}