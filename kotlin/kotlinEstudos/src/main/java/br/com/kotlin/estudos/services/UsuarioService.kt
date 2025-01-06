package br.com.kotlin.estudos.services

import br.com.kotlin.estudos.model.repository.financial.Usuario
import br.com.kotlin.estudos.repository.UsuarioRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UsuarioService(
        private val usuarioRepository: UsuarioRepository
) {

    fun findUserByEmailAuth(): Usuario? {
        val authentication  = SecurityContextHolder.getContext().authentication
        if(authentication != null ) {
            val userDetails = authentication.principal as UserDetails
            return usuarioRepository.findByEmail(userDetails.username).
            orElseThrow{ UsernameNotFoundException("User not found") }
        }
        return null
    }
}