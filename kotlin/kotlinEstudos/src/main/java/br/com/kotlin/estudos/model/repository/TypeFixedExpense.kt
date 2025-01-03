package br.com.kotlin.estudos.model.repository

import jakarta.persistence.*
import java.util.UUID


import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
@Table(name = "TIP_FIXED_EXP")
class TypeFixedExpense(
    @Id
    @Column(nullable = false)
    @JdbcTypeCode(SqlTypes.CHAR)
    val id: UUID = UUID.randomUUID(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usuario_id")
    @JdbcTypeCode(SqlTypes.CHAR)
    @JsonIgnore
    var usuario: Usuario?,

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo",insertable = false)
    val tipo: Long?,

        @Column(name = "tipo_desc")
        var tipoDesc: String,
) {

    /*override fun toString(): String {
        return "Usuario = [ ID = $id, Email = $email, Nome = $username, password = $password ]"
    }*/

}