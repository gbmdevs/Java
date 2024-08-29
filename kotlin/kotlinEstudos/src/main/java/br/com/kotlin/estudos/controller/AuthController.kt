package br.com.kotlin.estudos.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

import br.com.kotlin.estudos.model.dto.LoginUserDTO
import br.com.kotlin.estudos.model.dto.LoginResponse
import br.com.kotlin.estudos.model.dto.RegisterUserDto
import br.com.kotlin.estudos.model.Usuario
import br.com.kotlin.estudos.services.AuthenticationService
import br.com.kotlin.estudos.services.JwtService

import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/auth")
class AuthController(
       private val authenticationService: AuthenticationService,
       private val jwtService: JwtService
    ){

    @PostMapping("/signup")
    fun cadastrar(@RequestBody registerDto: RegisterUserDto): ResponseEntity<Usuario>{
        val user = authenticationService.signup(registerDto)
        return ResponseEntity.ok(user)
    }

    @PostMapping("/login")
    fun autenticar(@RequestBody login: LoginUserDTO): ResponseEntity<LoginResponse>{
        val user = authenticationService.authenticate(login)
        val jwtToken = jwtService.generateToken(user)
        val loginResponse = LoginResponse(jwtToken,jwtService.getJwtExpiration())
        return ResponseEntity.ok(loginResponse)
    }

}