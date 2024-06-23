package com.zerobase.api.exception

import org.springframework.http.HttpStatus

enum class CustomErrorCode(
        val statusCode: HttpStatus,
        val errorCode: String,
        val errorMessage: String
) {
    RESULT_NOT_FOUND(HttpStatus.BAD_REQUEST, "RESULT_NOT_FOUND", errorMessage = "대상을 찾을 수 없습니다."),
    USER_KEY_NOT_FOUND(HttpStatus.BAD_REQUEST, "USER_KEY_NOT_FOUND", errorMessage = "사용자 키를 찾을 수 없습니다.")
}