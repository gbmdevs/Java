package br.com.kotlin.estudos.services

import br.com.kotlin.estudos.model.repository.financial.Stock
import br.com.kotlin.estudos.repository.StocksRepository
import org.springframework.stereotype.Service

@Service
class StocksService(
        private val stocksRepository: StocksRepository
) {
    fun findAll(): List<Stock> = stocksRepository.findAll().toList()
}