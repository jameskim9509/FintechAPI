package com.zerobase.api.exception

import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApiExceptionHandler {
    @ExceptionHandler(CustomException::class)
    fun customExceptionHandler(customException: CustomException) =
            ErrorResponse(customException).toResponseEntity()

    @ExceptionHandler(Exception::class)
    fun exceptionHandler(exception: Exception) = ""
}