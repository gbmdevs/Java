package br.banco.entidade;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;  

import br.banco.util.EntidadeBase;

@Entity
@Table(name = "TIPO_ESTRATEGIA")
public class TipoEstrategia implements EntidadeBase {
    
    private Long id;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    @Column(name = "nomeEstrategia", unique=true)
    private String nomeEstrategia;

    public String getNomeEstrategia() {
        return this.nomeEstrategia;
    }

    public void setNomeEstrategia(String nomeEstrategia) {
        this.nomeEstrategia = nomeEstrategia;
    }



}
