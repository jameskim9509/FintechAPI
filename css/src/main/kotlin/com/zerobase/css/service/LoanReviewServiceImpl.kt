package com.zerobase.css.service

import com.zerobase.css.dto.LoanRequestDto
import org.springframework.stereotype.Service

@Service
class LoanReviewServiceImpl: LoanReviewService {
    override fun loanReview(
            loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ): LoanRequestDto.LoanRequestOutputDto {
        if (loanRequestInputDto.userIncomeAmount < 0) 
            throw RuntimeException("Invalid userIncomeAmount Param")
        if (loanRequestInputDto.userIncomeAmount < 10000000) 
            return LoanRequestDto.LoanRequestOutputDto(loanRequestInputDto.userKey, 0.0, 10000000)
        if (loanRequestInputDto.userIncomeAmount < 20000000)
            return LoanRequestDto.LoanRequestOutputDto(loanRequestInputDto.userKey, 10.0, 20000000)
        if (loanRequestInputDto.userIncomeAmount < 30000000)
            return LoanRequestDto.LoanRequestOutputDto(loanRequestInputDto.userKey, 9.0, 30000000)
        if (loanRequestInputDto.userIncomeAmount < 40000000) 
            return LoanRequestDto.LoanRequestOutputDto(loanRequestInputDto.userKey, 8.0, 40000000)
        if (loanRequestInputDto.userIncomeAmount < 50000000) 
            return LoanRequestDto.LoanRequestOutputDto(loanRequestInputDto.userKey, 7.0, 50000000)
        if (loanRequestInputDto.userIncomeAmount >= 50000000)
            return LoanRequestDto.LoanRequestOutputDto(loanRequestInputDto.userKey, 6.0, 60000000)
        
        throw RuntimeException("Invalid userIncomeAmount Param")
    }
}