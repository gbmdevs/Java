package br.com.kotlin.estudos.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping

@RestController
@RequestMapping("/auth")
class AuthController{

    @PostMapping("/login")
    fun autenticar(){

    }

}