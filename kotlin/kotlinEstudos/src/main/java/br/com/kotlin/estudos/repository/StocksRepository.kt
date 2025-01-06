package br.com.kotlin.estudos.repository

import br.com.kotlin.estudos.model.repository.financial.Stock
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StocksRepository: CrudRepository<Stock,Long> {

}