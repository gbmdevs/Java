package br.com.estudos.oauth2.model;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.Immutable;

@Entity(name = "V_DE_TESTE")
@Immutable
public class ViewDeTeste { 

    @Id
    private UUID id;

    private double value;

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }



}