package br.com.kotlin.estudos.model.dto.fixedExpense

import java.math.BigDecimal
import java.util.*

data class FixedExpenseDTO (
    val descExpense: String?,
    val value: BigDecimal?,
    val dueDate: Date?,
    val typeFixedExpense: TypeFixedExpenseDTO?
){}