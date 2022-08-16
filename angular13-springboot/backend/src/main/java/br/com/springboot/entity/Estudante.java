package br.com.springboot.entity;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.Id;  
import javax.persistence.Table;  
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

import br.com.springboot.entity.Login;

@Entity
@Table
public class Estudante{
    @Id
    @Column
    private int id;

    @Column
    private String nome;

    //@OneToOne
    //@JoinColumn(name = "idConta", referencedColumnName = "idConta", insertable = false, updatable = false)
    //private Login login;

  
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /* public Login getLogin() {
        return this.login;
    }

    public void setLogin(Login login) {
        this.login = login;
    } */

}