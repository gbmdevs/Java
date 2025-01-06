package br.com.kotlin.estudos.model.repository.financial

import jakarta.persistence.*
import java.util.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.math.BigDecimal
import java.sql.Date

@Entity
@Table(name="TYPE_BALANCE")
class TypeBalance(
     @Id
     @Column(nullable = false)
     private val type: Int,
     @Column(name="type_name")
     private val typeName: String,
     @Column(name="type_desc")
     private val typeDesc: String

){}