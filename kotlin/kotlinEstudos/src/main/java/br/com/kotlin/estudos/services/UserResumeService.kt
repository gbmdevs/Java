package br.com.kotlin.estudos.services

import br.com.kotlin.estudos.model.repository.financial.StockUserOperation
import br.com.kotlin.estudos.repository.StocksDataHistoryRepository
import br.com.kotlin.estudos.repository.StocksUserOperationRepository
import org.springframework.stereotype.Service

@Service
class UserResumeService(
        private val stocksDataHistoryRepository: StocksDataHistoryRepository,
        private val stockUserOperationRepository: StocksUserOperationRepository
) {
    fun findAll(): List<StockUserOperation> = stockUserOperationRepository.findAll().toList()
}