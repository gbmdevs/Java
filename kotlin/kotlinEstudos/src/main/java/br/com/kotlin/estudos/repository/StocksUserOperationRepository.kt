package br.com.kotlin.estudos.repository

import br.com.kotlin.estudos.model.repository.StockUserOperation
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StocksUserOperationRepository: CrudRepository<StockUserOperation,Long> {

}