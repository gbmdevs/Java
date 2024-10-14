package br.com.kotlin.estudos.services

import br.com.kotlin.estudos.model.dto.balance.BalanceResumeResponse
import br.com.kotlin.estudos.model.repository.Balance
import br.com.kotlin.estudos.model.repository.Stock
import br.com.kotlin.estudos.repository.BalanceRepository
import br.com.kotlin.estudos.repository.StocksRepository
import org.springframework.stereotype.Service

@Service
class BalanceService(
        private val balanceRepository: BalanceRepository
) {

    fun findByResumeBalance(): List<BalanceResumeResponse>?{
        try {
            return balanceRepository.findByResumeBalance()
        }catch (ex: Exception){
            println(ex)
            return null
        }
    }
}