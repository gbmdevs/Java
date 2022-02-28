package br.estudo.JUnit.entidade;
import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;  
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;  
import javax.persistence.FetchType;  
import br.estudo.JUnit.entidade.BolsaDeValores;

import java.math.BigDecimal;

@Entity
@Table(name = "HIST_BOLSA_VALORES")
public class HistoricoBolsaValores implements Serializable {

    private BolsaDeValores bolsadevalores;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)  
    @Column(name = "idHistBolsaValores")
    private Integer idHistBolsaValores;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idTicket")
    public BolsaDeValores getBolsaDeValores() {
        return bolsadevalores;
    }

    @Column(name = "abertura")
    private BigDecimal abertura;

    @Column(name = "fechamento")
    private BigDecimal fechamento;

    @Column(name = "maxima")
    private BigDecimal maxima;

    @Column(name = "minima")
    private BigDecimal minima;

    public void setBolsadevalores(BolsaDeValores bolsadevalores) {
        this.bolsadevalores = bolsadevalores;
    }

    public Integer getIdHistBolsaValores() {
        return this.idHistBolsaValores;
    }

    public void setIdHistBolsaValores(Integer idHistBolsaValores) {
        this.idHistBolsaValores = idHistBolsaValores;
    }

    public BigDecimal getAbertura() {
        return this.abertura;
    }

    public void setAbertura(BigDecimal abertura) {
        this.abertura = abertura;
    }

    public BigDecimal getFechamento() {
        return this.fechamento;
    }

    public void setFechamento(BigDecimal fechamento) {
        this.fechamento = fechamento;
    }

    public BigDecimal getMaxima() {
        return this.maxima;
    }

    public void setMaxima(BigDecimal maxima) {
        this.maxima = maxima;
    }

    public BigDecimal getMinima() {
        return this.minima;
    }

    public void setMinima(BigDecimal minima) {
        this.minima = minima;
    }
  

}