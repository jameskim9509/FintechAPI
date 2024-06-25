package com.zerobase.consumer.dto

import com.zerobase.domain.domain.LoanReview

data class LoanReviewDto (
        val userKey: String,
        val interest: Double,
        val limitAmount: Long
){
    fun toLoanReviewEntity(): LoanReview
    {
        return LoanReview(
            userKey = this.userKey,
            loanInterest = this.interest,
            loanLimitedAmount = this.limitAmount
        )
    }
}