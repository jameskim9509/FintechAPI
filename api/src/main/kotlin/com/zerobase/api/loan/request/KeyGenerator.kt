package com.zerobase.api.loan.request

import org.springframework.stereotype.Component
import java.util.*

@Component
class KeyGenerator {
    fun generate(): String =
        UUID.randomUUID().toString().replace("-", "")
}