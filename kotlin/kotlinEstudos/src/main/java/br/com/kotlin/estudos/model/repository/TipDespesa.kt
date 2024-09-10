package br.com.kotlin.estudos.model.repository
 
//import javax.persistence.Entity
//import javax.persistence.Table
//import javax.persistence.Column
//import javax.persistence.Id
//import java.util.UUID
import jakarta.persistence.*
import java.util.UUID

//import javax.persistence.JoinColumn

import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
@Table(name = "TIP_DESP_FIXA")
class TipDespesa(
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