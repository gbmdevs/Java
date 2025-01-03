package br.com.kotlin.estudos.model.dto.fixedExpense

import java.math.BigDecimal


data class FixedExpenseDTO (
    val descExpense: String,
    val value: BigDecimal
){}