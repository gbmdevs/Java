package br.com.kotlin.estudos.model.repository.financial.id

import java.io.Serializable
import java.sql.Date
import java.util.UUID

data class FixedExpenseId(
    val id: UUID = UUID.randomUUID(),
    val typeFixedExpense: UUID = UUID.randomUUID(),
    val dueDate: Date? = null
) : Serializable