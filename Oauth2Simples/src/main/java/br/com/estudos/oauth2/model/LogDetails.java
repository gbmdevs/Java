package br.com.estudos.oauth2.model;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity(name="log_details")
public class LogDetails { 

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="action")
    private String action;

    @Column(name="create_date_time")
    private Timestamp createdDateTime;

    @Column(name="value1")
    private String value1;

    public LogDetails(String action, String value1){
        this.action = action;
        this.value1 = value1;
        this.createdDateTime = new Timestamp(System.currentTimeMillis());
    }
   
    public Integer getId() {
        return this.id;
    }

    public Timestamp getCreatedDateTime() {
        return this.createdDateTime;
    }

    public void setCreatedDateTime(Timestamp createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getValue1() {
        return this.value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }



}