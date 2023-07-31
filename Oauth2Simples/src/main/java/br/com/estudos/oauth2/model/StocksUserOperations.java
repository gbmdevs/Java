package br.com.estudos.oauth2.model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.Type;
import java.util.UUID;

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


}