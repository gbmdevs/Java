package br.com.springboot.model;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.Id;  
import javax.persistence.Table;  

@Entity
@Table
public class Login{
    @Id
    @Column
    private int idConta;

    @Column
    private String login;

    @Column
    private String senha;


    public int getIdConta() {
        return this.idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}