package br.com.estudos.oauth2.model;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Usuario { 

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name="nome")
    private String nome;

    @Column(name="email")
    private String email;

    @Column(name="senha")
    private String senha;

    @Column(name="token")
    private String token;

    public Usuario(String nome,String email,String senha){
        this.nome  = nome;
        this.email = email;
        this.senha = senha;
        this.token = "";
        this.id = UUID.randomUUID();
    }

    public Usuario(){

    }


    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @PrePersist
    public void prePersist(){
         this.id = UUID.randomUUID();
    }

    @Override
    public String toString(){
        return "Usuario = [ ID =  "+ this.id + ", Email = " + this.email + ", Nome = " + this.nome  + ", Senha = " + this.senha + "]";
    }

}