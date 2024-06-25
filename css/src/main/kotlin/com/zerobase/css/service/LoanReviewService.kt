package com.zerobase.css.service

import com.zerobase.css.dto.LoanRequestDto

interface LoanReviewService {
    fun loanReview(
            loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ): LoanRequestDto.LoanRequestOutputDto

}