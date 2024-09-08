package br.com.kotlin.estudos.model.dto

data class RegisterUserDto(
    val username: String,
    val email: String,
    val password: String
){}