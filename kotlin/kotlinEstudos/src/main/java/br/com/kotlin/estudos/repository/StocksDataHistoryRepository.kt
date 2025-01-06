package br.com.kotlin.estudos.repository

import br.com.kotlin.estudos.model.repository.financial.StockDataHistory
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StocksDataHistoryRepository: CrudRepository<StockDataHistory,Long> {

}