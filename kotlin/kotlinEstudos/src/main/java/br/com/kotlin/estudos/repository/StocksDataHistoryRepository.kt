package br.com.kotlin.estudos.repository

import br.com.kotlin.estudos.model.repository.Stock
import br.com.kotlin.estudos.model.repository.StockDataHistory
import org.springframework.data.repository.CrudRepository

interface StocksDataHistoryRepository: CrudRepository<StockDataHistory,Long> {

}