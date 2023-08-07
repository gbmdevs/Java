package br.com.estudos.oauth2.model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.Type;
import java.util.UUID;
import java.util.Date;
import java.math.BigDecimal;

@Entity
@Table(name="STOCKS_USER_OPERATIONS")
public class StocksUserOperations{

    @Id    
    @GeneratedValue
    @Type(type = "uuid-char")
    private UUID id;

    @ManyToOne
    @JoinColumn(name="stocks_id")
    private Stocks stock;

    @Column(name="date_operate_buy")
    private Date dateOperateBuy;

    @Column(name="stock_value_buy")
    private BigDecimal stockValueBuy;

    @Column(name="qtd_stocks_buy")
    private Integer qtdStocksBuy;

    public Integer getQtdStocksBuy() {
        return this.qtdStocksBuy;
    }

    public void setQtdStocksBuy(Integer qtdStocksBuy) {
        this.qtdStocksBuy = qtdStocksBuy;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Stocks getStock() {
        return this.stock;
    }

    public void setStock(Stocks stock) {
        this.stock = stock;
    }

    public Date getDateOperateBuy() {
        return this.dateOperateBuy;
    }

    public void setDateOperateBuy(Date dateOperateBuy) {
        this.dateOperateBuy = dateOperateBuy;
    }

    public BigDecimal getStockValueBuy() {
        return this.stockValueBuy;
    }

    public void setStockValueBuy(BigDecimal stockValueBuy) {
        this.stockValueBuy = stockValueBuy;
    }


}