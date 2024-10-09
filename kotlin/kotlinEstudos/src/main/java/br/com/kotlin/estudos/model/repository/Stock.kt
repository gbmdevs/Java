package br.com.kotlin.estudos.model.repository

import jakarta.persistence.*
import java.util.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name="STOCK")
class Stock(
     @Id
     @Column(nullable = false)
     @JdbcTypeCode(SqlTypes.CHAR)
     val id: UUID = UUID.randomUUID(),

     @Column(name = "STOCK_TICKET")
     var stockTicket: String,

     @Column(name = "STOCK_LOC")
     var stockLoc: String,
){}