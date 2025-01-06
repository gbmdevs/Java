package br.com.kotlin.estudos.model.repository.financial

import jakarta.persistence.*
import java.util.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.math.BigDecimal
import java.time.LocalDate

@Entity
@Table(name="STOCK_DATA_HIST")
class StockDataHistory (
    @Id
    @Column(nullable = false)
    @JdbcTypeCode(SqlTypes.CHAR)
    val id: UUID = UUID.randomUUID(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="stock_id")
    @JdbcTypeCode(SqlTypes.CHAR)
    var stock: Stock?,

    @Column(nullable = false,name="STOCK_DATE")
    var dateStock: LocalDate,

    @Column(name="STOCK_OPEN")
    var stockOpen: BigDecimal,

    @Column(name="STOCK_CLOSE")
    var stockClose: BigDecimal,

    @Column(name="STOCK_HIGH")
    var stockHigh: BigDecimal,

    @Column(name="STOCK_LOW")
    var stockLow: BigDecimal
){}