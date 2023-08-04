package br.com.estudos.oauth2.dto;

import java.util.Date;

public class ResumePositionsStocks{

    private String  ticket;
    private Date    dateOperationBuy;
    private Double  percentValuation;   
    private Integer qtdPriceBuy;
    private Double  priceBuy;
    private Double  actualPrice;

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

    public Double getPercentValuation() {
        return this.percentValuation;
    }

    public void setPercentValuation(Double percentValuation) {
        this.percentValuation = percentValuation;
    }

    public Integer getQtdPriceBuy() {
        return this.qtdPriceBuy;
    }

    public void setQtdPriceBuy(Integer qtdPriceBuy) {
        this.qtdPriceBuy = qtdPriceBuy;
    }

    public Double getPriceBuy() {
        return this.priceBuy;
    }

    public void setPriceBuy(Double priceBuy) {
        this.priceBuy = priceBuy;
    }

    public Double getActualPrice() {
        return this.actualPrice;
    }

    public void setActualPrice(Double actualPrice) {
        this.actualPrice = actualPrice;
    }

}