package br.com.kotlin.estudos.model.repository

import java.util.*
import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name="STOCK_USER_OPER")
class StockUserOperation(
    @Id
    @Column(nullable = false)
    @JdbcTypeCode(SqlTypes.CHAR)
    val id: UUID = UUID.randomUUID()
){

}