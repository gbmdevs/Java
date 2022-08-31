package br.com.springboot.entity;


import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.Id;  
import javax.persistence.Table;  
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

@Entity
@Table
public class Coffee {
    
    @Id
    private Long coffee_id;

    @Column(length = 20)
    private String brand;

    @Column(length = 20)
    private String origin;
    
    @Column(length = 30)
    private String characteristics;

    public Long getCoffee_id() {
        return this.coffee_id;
    }

    public void setCoffee_id(Long coffee_id) {
        this.coffee_id = coffee_id;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getCharacteristics() {
        return this.characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }


}