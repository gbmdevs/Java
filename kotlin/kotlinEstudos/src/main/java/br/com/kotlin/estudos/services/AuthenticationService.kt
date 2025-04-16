package br.com.kotlin.estudos.services

import org.springframework.stereotype.Service

import br.com.kotlin.estudos.repository.UsuarioRepository
import br.com.kotlin.estudos.model.repository.financial.Usuario
import br.com.kotlin.estudos.model.dto.LoginUserDTO
import br.com.kotlin.estudos.model.dto.RegisterUserDto
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder

import org.springframework.security.core.userdetails.UsernameNotFoundException

@Service
class AuthenticationService(
       private val userRepository: UsuarioRepository,
       private val authenticationManager: AuthenticationManager,
       private val passwordEncoder: PasswordEncoder 
    ){

        fun signup(input: RegisterUserDto): Usuario {
            val user = Usuario(
                usernameAcc = input.username,
                email = input.email,
                passwordAcc = passwordEncoder.encode(input.password),
                token = "nulo"
            )
            return userRepository.save(user)
        }

        fun authenticate(input: LoginUserDTO): Usuario {
            authenticationManager.authenticate(UsernamePasswordAuthenticationToken(
                input.email,
                input.password
            ))

            return userRepository.findByEmail(input.email)
               .orElseThrow{ UsernameNotFoundException("User not found")}
        }

}