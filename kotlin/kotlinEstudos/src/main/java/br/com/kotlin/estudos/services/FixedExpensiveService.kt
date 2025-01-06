package br.com.kotlin.estudos.services

import br.com.kotlin.estudos.model.dto.balance.BalanceResumeResponse
import br.com.kotlin.estudos.model.repository.financial.FixedExpense
import br.com.kotlin.estudos.model.repository.financial.Stock
import br.com.kotlin.estudos.repository.BalanceRepository
import br.com.kotlin.estudos.repository.FixedExpensiveRepository
import org.springframework.stereotype.Service

@Service
class FixedExpensiveService(
        private val fixedExpensiveRepository: FixedExpensiveRepository
) {
    fun findAll(): List<FixedExpense> = fixedExpensiveRepository.findAll().toList()
}