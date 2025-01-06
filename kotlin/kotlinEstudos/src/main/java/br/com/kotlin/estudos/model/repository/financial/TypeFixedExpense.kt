package br.com.kotlin.estudos.model.repository.financial

import br.com.kotlin.estudos.model.repository.financial.id.TypeFixedExpenseId
import jakarta.persistence.*


import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*

@Entity
@Table(name = "TYPE_FIXED_EXPENSE")
class TypeFixedExpense(
    @Id
    @Column(name = "id",insertable = false)
    @JdbcTypeCode(SqlTypes.CHAR)
    val id: UUID,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usuario_id",referencedColumnName ="id")
    @JdbcTypeCode(SqlTypes.CHAR)
    @JsonIgnore
    var usuario: Usuario?,

    @Column(name = "type_desc")
    var typeDesc: String,
    @Column(name = "is_fixed")
    var isFixed: Boolean
) {

    /*override fun toString(): String {
        return "Usuario = [ ID = $id, Email = $email, Nome = $username, password = $password ]"
    }*/

}