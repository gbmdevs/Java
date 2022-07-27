package br.com.amazonaws.model;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "administradores")
public class Administrador{
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "nome", length = 100, nullable = false)
  private String nome;

  @Column(name = "email", length = 180, nullable = false)
  private String email;

  @Column(name = "senha", length = 255, nullable = false)
  private String senha;

  @Column(name = "observacao")
  @Type(type = "text")
  private String observacao;


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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}