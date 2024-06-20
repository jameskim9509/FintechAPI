package com.zerobase.api.loan.review

class LoanReviewDto {
    data class LoanReviewOutputDto(
            val userKey: String,
            val loanResult: LoanResult
    )

    data class LoanResult(
            val userLimitAmount: Long,
            val loanInterest: Double
    )

    data class LoanReview(
            val userKey: String,
            val loanLimitAmount: Long,
            val loanInterest: Double
    )
}