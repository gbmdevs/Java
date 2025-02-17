package br.com.kotlin.estudos.repository

import br.com.kotlin.estudos.model.repository.financial.Balance
import br.com.kotlin.estudos.model.repository.financial.Stock
import br.com.kotlin.estudos.model.repository.financial.Usuario
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BalanceRepository: CrudRepository<Balance,Long> {

    fun save(balance: Balance)
    fun findByUser(user: Usuario?): List<Balance>?
}