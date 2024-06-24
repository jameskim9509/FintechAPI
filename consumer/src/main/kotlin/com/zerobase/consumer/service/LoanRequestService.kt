package com.zerobase.consumer.service

import com.zerobase.kafka.dto.LoanRequestDto

interface LoanRequestService {
    fun loanRequest(loanReuqestDto: LoanRequestDto)
}