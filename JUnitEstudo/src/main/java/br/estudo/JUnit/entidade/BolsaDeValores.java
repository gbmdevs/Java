
package br.estudo.JUnit.entidade;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;  

@Entity
@Table(name = "BOLSA_DE_VALORES")
public class BolsaDeValores implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)  
    @Column(name = "idTicket")
    private Integer idTicket;

    @Column(name = "nomeTicket", unique=true)
    private String nomeTicket;

    @Column(name = "nomeBalcao")
    private String nomeBalcao;

    @Column(name = "descricaoTicket")
    private String descricaoTicket;



    public Integer getIdTicket() {
        return this.idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public String getNomeTicket() {
        return this.nomeTicket;
    }

    public void setNomeTicket(String nomeTicket) {
        this.nomeTicket = nomeTicket;
    }

    public String getNomeBalcao() {
        return this.nomeBalcao;
    }

    public void setNomeBalcao(String nomeBalcao) {
        this.nomeBalcao = nomeBalcao;
    }

    public String getDescricaoTicket() {
        return this.descricaoTicket;
    }

    public void setDescricaoTicket(String descricaoTicket) {
        this.descricaoTicket = descricaoTicket;
    }

}