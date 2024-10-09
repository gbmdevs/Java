package br.com.kotlin.estudos.repository

import br.com.kotlin.estudos.model.repository.Stock
import org.springframework.data.repository.CrudRepository

interface StocksRepository: CrudRepository<Stock,Long> {

}