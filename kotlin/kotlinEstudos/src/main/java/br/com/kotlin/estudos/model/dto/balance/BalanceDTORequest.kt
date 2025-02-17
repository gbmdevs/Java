package br.com.kotlin.estudos.model.dto.balance

import java.math.BigDecimal
import java.sql.Date

data class BalanceDTORequest(
  var value: BigDecimal,
  var typeBalance: Int,
  val dateConsume: Date,
  val description: String
){}
