package br.com.kotlin.estudos.model.dto.stock

import java.time.LocalDate

data class  StockRequestDTO (
    val dateBegin: LocalDate,
    val dateEnd: LocalDate
){}