package br.com.kotlin.estudos.model.repository

import org.springframework.security.core.userdetails.UserDetails

import java.util.UUID

import jakarta.persistence.*

import org.hibernate.annotations.Type

import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import org.springframework.security.core.GrantedAuthority

@Entity
@Table(name = "usuario")
class Usuario(

    @Id
    @Column(nullable = false)
    @JdbcTypeCode(SqlTypes.CHAR)
    val id: UUID = UUID.randomUUID(),

    @Column(name = "username")
    var usernameAcc: String,

    @Column(name = "email")
    var email: String,

    @Column(name = "password")
    var passwordAcc: String,

    @Column(name = "token")
    var token: String

): UserDetails{

/* 
    constructor(username: String, email: String, password: String) : this() {
        this.username = username
        this.email = email
        this.password = password
        this.token = ""
    }*/


    override fun getAuthorities(): Collection<GrantedAuthority> {
        return emptyList() // Retorna uma lista vazia, adaptável conforme necessidade
    }

    override fun getUsername(): String {
        return email
    }

    override fun getPassword(): String {
        return passwordAcc
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun toString(): String {
        return "Usuario = [ ID = $id, Email = $email, Nome = $username, password = $password ]"
    }

}