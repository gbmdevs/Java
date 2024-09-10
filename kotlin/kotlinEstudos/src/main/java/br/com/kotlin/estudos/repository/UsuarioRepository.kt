package br.com.kotlin.estudos.repository

import br.com.kotlin.estudos.model.repository.Usuario

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UsuarioRepository : CrudRepository<Usuario, Long> {

    fun findByEmail(email: String): Optional<Usuario>

}