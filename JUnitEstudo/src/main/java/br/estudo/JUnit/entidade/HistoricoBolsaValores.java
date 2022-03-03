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
import javax.persistence.CascadeType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "HIST_BOLSA_VALORES")
public class HistoricoBolsaValores implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)  
    @Column(name = "idHistBolsaValores")
    private Integer idHistBolsaValores;

    @ManyToOne
    @JoinColumn(name = "idTicket")
    private BolsaDeValores bolsadevalores;

    @Temporal(TemporalType.DATE)
    @Column(name = "dataFechamento")
    private Date dataFechamento;

    @Column(name = "abertura")
    private BigDecimal abertura;

    @Column(name = "fechamento")
    private BigDecimal fechamento;

    @Column(name = "maxima")
    private BigDecimal maxima;

    @Column(name = "minima")
    private BigDecimal minima;


    public Integer getIdHistBolsaValores() {
        return this.idHistBolsaValores;
    }

    public void setIdHistBolsaValores(Integer idHistBolsaValores) {
        this.idHistBolsaValores = idHistBolsaValores;
    }

    public BolsaDeValores getBolsadevalores() {
        return this.bolsadevalores;
    }

    public void setBolsadevalores(BolsaDeValores bolsadevalores) {
        this.bolsadevalores = bolsadevalores;
    }

    public Date getDataFechamento() {
        return this.dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
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
   

    @Override
    public String toString(){
        return " Fechamento = " +// this.dataFechamento + 
               " Abertura   = " + this.abertura + 
               " Minima     ="  + this.minima; 
    }


}