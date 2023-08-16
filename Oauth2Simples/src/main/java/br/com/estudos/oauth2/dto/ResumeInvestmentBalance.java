package br.com.estudos.oauth2.dto;

import java.math.BigDecimal;

public class ResumeInvestmentBalance{

    private BigDecimal availableBalance;

    public ResumeInvestmentBalance(){
        this.availableBalance = new BigDecimal(0.0);
    }
    public BigDecimal getAvailableBalance() {
        return this.availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }



}