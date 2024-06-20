package com.zerobase.api.loan.review

interface LoanReviewService {
    fun loanReviewMain(userKey:String): LoanReviewDto.LoanReviewOutputDto

    fun getLoanResult(userKey: String) : LoanReviewDto.LoanReview
}