package com.zerobase.api.loan.review

import com.zerobase.domain.repository.LoanReviewRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class LoanReviewServiceImpl(
        private val loanReviewRepository: LoanReviewRepository
): LoanReviewService {
    override fun loanReviewMain(userKey: String): LoanReviewDto.LoanReviewOutputDto {
        val loanReviewDto = getLoanResult(userKey)
        return LoanReviewDto.LoanReviewOutputDto(
                userKey = loanReviewDto.userKey,
                loanResult = LoanReviewDto.LoanResult(
                        userLimitAmount = loanReviewDto.loanLimitAmount,
                        loanInterest = loanReviewDto.loanInterest
                )
        )
    }

    override fun getLoanResult(userKey: String): LoanReviewDto.LoanReview {
        val loanReview = loanReviewRepository.findByUserKey(userKey)
                ?: throw RuntimeException("Review Not Found")
        return LoanReviewDto.LoanReview(
                userKey = loanReview.userKey,
                loanLimitAmount = loanReview.loanLimitedAmount,
                loanInterest = loanReview.loanInterest
        )
    }
}