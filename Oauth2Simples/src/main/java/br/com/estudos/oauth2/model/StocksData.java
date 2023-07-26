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

@Entity
public class StocksData{

    @Id    
    @GeneratedValue
    @Type(type = "uuid-char")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "stocks_id")
    private Stocks stocks;

    private BigDecimal open;

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



}