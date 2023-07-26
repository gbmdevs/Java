package br.com.estudos.oauth2.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Entity
public class Stocks{

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name="ticket")
    private String ticket;

    @Column(name="name")
    private String name;

    @Column(name="region")
    private String region;

    public UUID getId() {
        return this.id;
    }
    
    public String getTicket() {
        return this.ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
