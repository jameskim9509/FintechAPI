package com.zerobase.consumer.service

import com.zerobase.consumer.dto.LoanReviewDto
import com.zerobase.domain.repository.LoanReviewRepository
import com.zerobase.kafka.dto.LoanRequestDto
import org.springframework.stereotype.Service
import org.springframework.boot.web.client.RestTemplateBuilder
import java.time.Duration

@Service
class LoanRequestServiceImpl(
    private val loanReviewRepository: LoanReviewRepository
): LoanRequestService{
    companion object {
        const val cssUrl = "http://localhost:8085/css/api/v1/request"
    }

    override fun loanRequest(loanReuqestKafkaDto: LoanRequestDto) {
        val loanReviewDto = getLoanReviewFromCSS(loanReuqestKafkaDto)
        loanReviewRepository.save(loanReviewDto.toLoanReviewEntity())
    }

    private fun getLoanReviewFromCSS(
            loanRequestDto: LoanRequestDto
    ): LoanReviewDto
    {
        val restTemplate = RestTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(1000))
                .setReadTimeout(Duration.ofMillis(1000))
                .build()

        return restTemplate.postForEntity(
                cssUrl, loanRequestDto, LoanReviewDto::class.java
        ).body!!
    }
}