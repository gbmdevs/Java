package br.com.kotlin.estudos.model.repository.financial

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.util.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.math.BigDecimal
import java.sql.Date

@Entity
@Table(name="BALANCE")
class Balance(
     @Id
     @Column(nullable = false)
     @JdbcTypeCode(SqlTypes.CHAR)
     val id: UUID = UUID.randomUUID(),

     @JsonIgnore
     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name="usuario_id")
     @JdbcTypeCode(SqlTypes.CHAR)
     var user: Usuario?,

     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name="type", referencedColumnName = "type")
     var typeBalance: TypeBalance?,

     @Column(name = "VALUE_CONSUME")
     var valueConsume: BigDecimal,

     @Column(name = "DATE_CONSUME")
     var dateConsume: Date,

     @Column(name = "DESCRIPTION")
     var description: String

     ){}