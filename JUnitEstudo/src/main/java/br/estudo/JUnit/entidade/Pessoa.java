package br.estudo.JUnit.entidade;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable{

   @Id
   @GeneratedValue
   @Column(name = "id")
   private Integer id;

   @Column(name = "nome")
   private String nome;

   public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}