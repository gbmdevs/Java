package br.com.estudos.oauth2.dto;

import java.math.BigDecimal;
import br.com.estudos.oauth2.model.TypeBalance;

public class ResumeBalance{

    private TypeBalance typeBalance;
    private BigDecimal value;

    public ResumeBalance(TypeBalance typeBalance, BigDecimal value ){
        this.typeBalance = typeBalance;
        this.value = value;
    }

    public TypeBalance getTypeBalance() {
        return this.typeBalance;
    }

    public void setTypeBalance(TypeBalance typeBalance) {
        this.typeBalance = typeBalance;
    }

    public BigDecimal getValue() {
        return this.value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }



}