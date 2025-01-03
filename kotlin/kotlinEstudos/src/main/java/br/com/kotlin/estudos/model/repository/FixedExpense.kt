package br.com.kotlin.estudos.model.repository

import jakarta.persistence.*
import java.util.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.math.BigDecimal
import java.sql.Date

@Entity
@Table(name="FIXED_EXPENSE")
class FixedExpense(
     @Id
     @Column(nullable = false)
     @JdbcTypeCode(SqlTypes.CHAR)
     val id: UUID = UUID.randomUUID(),


){}