package br.com.estudos.oauth2.dto;

import java.util.Date;
import java.math.BigDecimal;

public class ResumePositionsStocks{

    private String      ticket;
    private Date        dateOperationBuy;
    private BigDecimal  percentValuation;   
    private Integer     qtdPriceBuy;
    private BigDecimal  priceBuy;
    private BigDecimal  actualPrice;


    public String getTicket() {
        return this.ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Date getDateOperationBuy() {
        return this.dateOperationBuy;
    }

    public void setDateOperationBuy(Date dateOperationBuy) {
        this.dateOperationBuy = dateOperationBuy;
    }

    public BigDecimal getPercentValuation() {
        return this.percentValuation;
    }

    public void setPercentValuation(BigDecimal percentValuation) {
        this.percentValuation = percentValuation;
    }

    public Integer getQtdPriceBuy() {
        return this.qtdPriceBuy;
    }

    public void setQtdPriceBuy(Integer qtdPriceBuy) {
        this.qtdPriceBuy = qtdPriceBuy;
    }

    public BigDecimal getPriceBuy() {
        return this.priceBuy;
    }

    public void setPriceBuy(BigDecimal priceBuy) {
        this.priceBuy = priceBuy;
    }

    public BigDecimal getActualPrice() {
        return this.actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }


}