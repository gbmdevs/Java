package br.banco.entidade;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;  


@Entity
@Table(name = "TIPO_ESTRATEGIA")
public class tipoEstrategia implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)  
    @Column(name = "idTipoEstrategia")
    private Integer idTipoEstrategia;

    @Column(name = "nomeEstrategia")
    private String nomeEstrategia;

    public Integer getIdTipoEstrategia() {
        return this.idTipoEstrategia;
    }

    public void setIdTipoEstrategia(Integer idTipoEstrategia) {
        this.idTipoEstrategia = idTipoEstrategia;
    }

    public String getNomeEstrategia() {
        return this.nomeEstrategia;
    }

    public void setNomeEstrategia(String nomeEstrategia) {
        this.nomeEstrategia = nomeEstrategia;
    }



}
