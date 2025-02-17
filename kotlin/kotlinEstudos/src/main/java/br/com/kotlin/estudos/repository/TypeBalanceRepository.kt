package br.com.kotlin.estudos.repository

import br.com.kotlin.estudos.model.repository.financial.Stock
import br.com.kotlin.estudos.model.repository.financial.TypeBalance
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TypeBalanceRepository: CrudRepository<TypeBalance,Long> {

    fun findByType(type: Int): TypeBalance

}