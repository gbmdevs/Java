package br.com.springboot.entity;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.Id;  
import javax.persistence.Table;  

@Entity
@Table(name="MERCADO_FINANCEIRO")
public class MercadoFinanceiro{
     
    @Id
    @Column
    private long idTicketStock;

    @Column
    private String ticket;

    @Column
    private String fullNameTicket;

    public long getIdTicketStock() {
        return this.idTicketStock;
    }

    public void setIdTicketStock(long idTicketStock) {
        this.idTicketStock = idTicketStock;
    }

    public String getTicket() {
        return this.ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getFullNameTicket() {
        return this.fullNameTicket;
    }

    public void setFullNameTicket(String fullNameTicket) {
        this.fullNameTicket = fullNameTicket;
    }
}