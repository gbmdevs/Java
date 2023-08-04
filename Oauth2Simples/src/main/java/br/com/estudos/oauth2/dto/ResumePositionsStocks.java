package br.com.estudos.oauth2.dto;

import java.util.Date;

public class ResumePositionsStocks{

    private String ticket;

    private Date dateOperationBuy;

    public Date getDateOperationBuy() {
        return this.dateOperationBuy;
    }

    public void setDateOperationBuy(Date dateOperationBuy) {
        this.dateOperationBuy = dateOperationBuy;
    }

    public String getTicket() {
        return this.ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }


}