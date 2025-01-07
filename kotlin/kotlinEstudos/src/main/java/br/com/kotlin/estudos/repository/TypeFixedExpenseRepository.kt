package br.com.kotlin.estudos.repository

import br.com.kotlin.estudos.model.repository.financial.TypeFixedExpense

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TypeFixedExpenseRepository : CrudRepository<TypeFixedExpense, Long> {

    fun findById(id: UUID): TypeFixedExpense

}