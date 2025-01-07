package br.com.kotlin.estudos.model.dto.fixedExpense

import java.math.BigDecimal
import java.util.UUID

data class TypeFixedExpenseDTO (
    val id: UUID,
    val typeDesc: String,
    val isActive: Boolean
){}