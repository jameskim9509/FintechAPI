package com.zerobase.consumer.service

import com.zerobase.kafka.dto.LoanRequestDto
import org.springframework.stereotype.Service

@Service
class LoanRequestServiceImpl: LoanRequestService {
    override fun loanRequest(loanReuqestKafkDto: LoanRequestDto) {
        TODO("Not yet implemented")
    }
}