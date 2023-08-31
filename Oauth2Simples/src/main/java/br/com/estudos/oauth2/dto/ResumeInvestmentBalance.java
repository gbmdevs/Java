package br.com.estudos.oauth2.dto;

import java.math.BigDecimal;
import br.com.estudos.oauth2.model.TypeBalance;

public class ResumeInvestmentBalance{

    private TypeBalance typeBalance;
    private BigDecimal  availableBalance;
    private BigDecimal  totalBalance;

    public ResumeInvestmentBalance(TypeBalance typeBalance){
        this.typeBalance = typeBalance;
    }

    public ResumeInvestmentBalance(){
        this.availableBalance = new BigDecimal(0.0);
        this.totalBalance     = new BigDecimal(0.0);
    }
    public BigDecimal getAvailableBalance() {
        return (this.availableBalance == null ? new BigDecimal(0.0) : this.availableBalance);
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public BigDecimal getTotalBalance() {
        return (this.totalBalance == null ? new BigDecimal(0.0) : this.totalBalance);
    }

    public void setTotalBalance(BigDecimal totalBalance) {
        this.totalBalance = totalBalance;
    }

    public TypeBalance getTypeBalance() {
        return this.typeBalance;
    }

    public void setTypeBalance(TypeBalance typeBalance) {
        this.typeBalance = typeBalance;
    }


}
