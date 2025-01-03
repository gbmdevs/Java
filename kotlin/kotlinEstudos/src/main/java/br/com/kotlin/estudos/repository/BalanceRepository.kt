package br.com.kotlin.estudos.repository

import br.com.kotlin.estudos.model.dto.balance.BalanceResumeResponse
import br.com.kotlin.estudos.model.repository.Balance
import br.com.kotlin.estudos.model.repository.mapper.BalanceRowMapper
import org.springframework.data.jpa.repository.Query

import org.springframework.data.repository.CrudRepository
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class BalanceRepository(
        private val jdbcTemplate: JdbcTemplate
)  {
    fun findByResumeBalance(): List<BalanceResumeResponse>{
        val sql = """SELECT tb.type, tb.type_name, COALESCE(SUM(b.value_consume),0) as value_consume 
           FROM balance b 
            right JOIN type_balance tb ON tb.type = b.type
         GROUP BY tb.type, tb.type_name""".trimIndent()

        return jdbcTemplate.query(sql, BalanceRowMapper())
    }

}