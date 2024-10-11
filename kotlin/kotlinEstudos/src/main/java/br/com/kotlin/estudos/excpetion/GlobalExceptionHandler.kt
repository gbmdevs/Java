package br.com.kotlin.estudos.excpetion

import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.http.ProblemDetail

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(Exception::class)
    fun handleSecurityException(exception: java.lang.Exception): ProblemDetail?{
        val errorDetail: ProblemDetail? = null;

        exception.printStackTrace();

        return errorDetail;

    }
}