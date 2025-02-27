package com.zerobase.api.loan.review

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fintech/api/v1")
class LoanReviewController (
        private val loanReviewService: LoanReviewService
){
    @GetMapping("/review/{userKey}")
    fun getReviewData(
            @PathVariable("userKey") userKey: String
    ): ResponseEntity<LoanReviewDto.LoanReviewOutputDto> {
        return ResponseEntity.ok(
                loanReviewService.loanReviewMain(userKey)
        )
    }
}