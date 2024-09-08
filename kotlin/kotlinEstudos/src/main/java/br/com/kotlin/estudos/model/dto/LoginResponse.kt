package br.com.kotlin.estudos.model.dto 

data class LoginResponse(
    val token: String,
    val expiresIn: Long
){}