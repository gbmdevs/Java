package br.com.kotlin.estudos.services

import br.com.kotlin.estudos.model.repository.Stock
import br.com.kotlin.estudos.model.repository.StockDataHistory
import br.com.kotlin.estudos.model.repository.StockUserOperation
import br.com.kotlin.estudos.repository.StocksDataHistoryRepository
import br.com.kotlin.estudos.repository.StocksRepository
import br.com.kotlin.estudos.repository.StocksUserOperationRepository
import org.springframework.stereotype.Service

@Service
class UserResumeService(
        private val stocksDataHistoryRepository: StocksDataHistoryRepository,
        private val stockUserOperationRepository: StocksUserOperationRepository
) {
    fun findAll(): List<StockUserOperation> = stockUserOperationRepository.findAll().toList()
}