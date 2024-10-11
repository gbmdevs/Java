package br.com.kotlin.estudos.model.dto.balance

import java.math.BigDecimal

data class BalanceResumeResponse(
        val type: Int,
        val typeName: String,
        val valueConsume: BigDecimal
){}
