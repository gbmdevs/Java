package br.com.kotlin.estudos.model.repository

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.math.BigDecimal
import java.time.LocalDate

@Entity
@Table(name="STOCK_USER_OPER")
class StockUserOperation(
    @Id
    @Column(nullable = false)
    @JdbcTypeCode(SqlTypes.CHAR)
    val id: UUID = UUID.randomUUID(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usuario_id")
    @JdbcTypeCode(SqlTypes.CHAR)
    @JsonIgnore
    var usuario: Usuario?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="stock_id")
    @JdbcTypeCode(SqlTypes.CHAR)
    var stock: Stock?,

    @Column(name="oper_buy_price")
    var operBuyPrice: BigDecimal,

    @Column(nullable = false,name="oper_buy_date")
    var operBuyDate: LocalDate,

    @Column(name="oper_buy_qt")
    var operBuyQt: BigDecimal,
){

}