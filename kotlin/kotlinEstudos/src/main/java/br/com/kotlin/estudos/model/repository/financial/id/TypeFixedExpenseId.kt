package br.com.kotlin.estudos.model.repository.financial.id

import java.io.Serializable
import java.util.UUID

data class TypeFixedExpenseId(
    val usuario: UUID = UUID.randomUUID(),
    val id: UUID = UUID.randomUUID()
) : Serializable