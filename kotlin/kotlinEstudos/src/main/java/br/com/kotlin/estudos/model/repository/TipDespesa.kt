package br.com.kotlin.estudos.model.repository
 
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Column
import javax.persistence.Id
import java.util.UUID

import br.com.kotlin.estudos.model.repository.Usuario

import org.hibernate.annotations.Type

import javax.persistence.JoinColumn

import org.springframework.security.core.GrantedAuthority

@Entity
@Table(name = "TIP_DESP_FIXA")
class TipDespesa(

    @Id
    @Column(nullable = false)
    @Type(type="uuid-char")
    val id: UUID = UUID.randomUUID(),

    @JoinColumn(name="stocks_id")
    @Column(name = "usuario_id")
    var usuario: Usuario,

    @Column(name = "tipo")
    var tipo: String,

    @Column(name = "tipo_desc")
    var tipoDesc: String,
) {

    /*override fun toString(): String {
        return "Usuario = [ ID = $id, Email = $email, Nome = $username, password = $password ]"
    }*/

}