package br.com.estudos.oauth2.dto;

import java.util.Date;
import java.math.BigDecimal;

import br.com.estudos.oauth2.annotation.ExcelHeaderColumn;

public class ResumePositionsStocks{

    @ExcelHeaderColumn("Ação")
    private String      ticket;
    @ExcelHeaderColumn("Data de Compra")
    private Date        dateOperationBuy;
    @ExcelHeaderColumn("Percentual de valorizacao")
    private BigDecimal  percentValuation;   
    @ExcelHeaderColumn("Qtde. Compra")
    private Integer     qtdPriceBuy;    
    @ExcelHeaderColumn("Preço de Compra")
    private BigDecimal  priceBuy;
    @ExcelHeaderColumn("Ultimo Fechamento")
    private BigDecimal  actualPrice;
    private BigDecimal  resultOperation;


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
        return (this.actualPrice == null ? new BigDecimal(0.0) : this.actualPrice);
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public BigDecimal getResultOperation() {
        return (this.resultOperation == null ? new BigDecimal(0.0) : this.resultOperation);
    }

    public void setResultOperation(BigDecimal resultOperation) {
        this.resultOperation = resultOperation;
    }


}