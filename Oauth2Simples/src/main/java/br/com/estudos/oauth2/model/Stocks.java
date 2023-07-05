package br.com.estudos.oauth2.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;

import java.util.UUID;

@Entity
public class Stocks{

    @Id
    private UUID id;

    @Column(name="ticket")
    private String ticket;

    @Column(name="name")
    private String name;

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

}