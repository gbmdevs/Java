package br.com.kotlin.estudos.repository

import br.com.kotlin.estudos.model.repository.Vote
import org.springframework.data.jpa.repository.JpaRepository

interface VoteRepository : JpaRepository<Vote, Long> {
    fun findByOption(option: String): Vote?
}