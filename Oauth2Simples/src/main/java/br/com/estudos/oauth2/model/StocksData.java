package br.com.estudos.oauth2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class StocksData{

    @Id    
    @GeneratedValue
    @Type(type = "uuid-char")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "stocks_id")
    private Stocks stocks;

    @Column(name="date_close")
    private Date dateClose;

    @Column
    private BigDecimal open;

    @Column(name="value_close")
    private BigDecimal valueClose;
    
    @Column(name="adj_close")
    private BigDecimal adjClose;

    public BigDecimal getAdjClose() {
        return this.adjClose;
    }

    public void setAdjClose(BigDecimal adjClose) {
        this.adjClose = adjClose;
    }

    public BigDecimal getValueClose() {
        return this.valueClose;
    }

    public void setValueClose(BigDecimal valueClose) {
        this.valueClose = valueClose;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return this.id;
    }

    public Stocks getStocks() {
        return this.stocks;
    }

    public void setStocks(Stocks stocks) {
        this.stocks = stocks;
    }

    public BigDecimal getOpen() {
        return this.open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }
    
    public Date getDateClose() {
        return this.dateClose;
    }

    public void setDateClose(Date dateClose) {
        this.dateClose = dateClose;
    }

    @Override
    public String toString(){
        return "[StocksData { Dateclose = "+ this.dateClose +" } ]";
    }

}