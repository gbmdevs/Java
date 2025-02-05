package br.com.kotlin.estudos.model.dto.resumeOperation

import java.math.BigDecimal
import java.util.*

data class ResumeOperationResponse (
    val id: String,
    val ticket: String,
    val operBuyPrice: BigDecimal?,
    val stockClose: BigDecimal,
    val stockDate: Date?,
    val operBuyQtd: BigDecimal?
){
    val percentValuation: BigDecimal? = calculatePercentValuation()

    private fun calculatePercentValuation(): BigDecimal? {
        return if (operBuyPrice != null && (stockClose != null && stockClose != BigDecimal.ZERO)) {
            stockClose.subtract(operBuyPrice)
                .divide(operBuyPrice, 5, BigDecimal.ROUND_HALF_UP)
                .multiply(BigDecimal.valueOf(100))
        } else {
            null
        }
    }
}