package br.com.estudos.oauth2.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Entity
public class TypeBalance{

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name="name")
    private String name;

    @Column(name="situation")
    private String situation;

    @Column(name="type_company")
    private String typeCompany;    
    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSituation() {
        return this.situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getTypeCompany() {
        return this.typeCompany;
    }

    public void setTypeCompany(String typeCompany) {
        this.typeCompany = typeCompany;
    }

}
