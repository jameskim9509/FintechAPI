package com.zerobase.css.dto

class LoanRequestDto {
    data class LoanRequestInputDto(
            val userKey: String,
            val userName: String,
            val userIncomeAmount: Long,
            val userRegistrationNumber: String
    )

    data class LoanRequestOutputDto(
            val userKey: String,
            val interest: Double,
            val limitAmount: Long
    )
}