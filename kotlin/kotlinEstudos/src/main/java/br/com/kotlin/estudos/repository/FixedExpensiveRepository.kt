package br.com.kotlin.estudos.repository

import br.com.kotlin.estudos.model.dto.balance.BalanceResumeResponse
import br.com.kotlin.estudos.model.repository.financial.FixedExpense
import br.com.kotlin.estudos.model.repository.financial.StockDataHistory
import br.com.kotlin.estudos.model.repository.financial.mapper.BalanceRowMapper
import org.springframework.data.repository.CrudRepository

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
interface FixedExpensiveRepository: CrudRepository<FixedExpense, Long> {

}