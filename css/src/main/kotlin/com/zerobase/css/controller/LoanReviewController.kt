package com.zerobase.css.controller

import com.zerobase.css.dto.LoanRequestDto
import com.zerobase.css.service.LoanReviewService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/css/api/v1")
class LoanReviewController (
    private val loanReviewService: LoanReviewService
){
    @PostMapping("/request")
    fun loanReview(
            @RequestBody loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ): LoanRequestDto.LoanRequestOutputDto
    {
        return loanReviewService.loanReview(loanRequestInputDto)
    }
}