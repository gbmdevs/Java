package br.com.estudos.oauth2.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Balance{

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_type_balance")
    private TypeBalance typeBalance;

    @Column
    private BigDecimal value;

    public UUID getId() {
        return this.id;
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
