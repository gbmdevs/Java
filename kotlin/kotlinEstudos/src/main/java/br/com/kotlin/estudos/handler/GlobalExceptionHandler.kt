package br.com.kotlin.estudos.handler

import br.com.kotlin.estudos.model.dto.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun handleGenericException(ex: Exception): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse (
            code    = 500,
            message =  "An unexpected error occurred: ${ex.message}"
        )
        return ResponseEntity(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR)
    }
}