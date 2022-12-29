package br.com.estudo.oauth.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.NamedEntityGraph;

import br.com.estudo.oauth.utils.Modelos;

@Entity
@NamedEntityGraph(name = "perfil.permissoes")
public class Usuario extends Modelos{ 

   @Id
   private Long id;
  
   @NotEmpty
   @Size(min = 1, max = 20)
   @Column(unique = true)
   private String login;

   @Column
   @Size(min = 1, max = 50)
   private String nome;

   @NotEmpty
   private String senha;

   @ManyToOne(optional = false)
   private Perfil perfil;


   @Override
   public Long getId() {
      return this.id;
   }

   public void setId(Long id) {
      this.id = id;
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

   public Perfil getPerfil() {
      return this.perfil;
   }

   public void setPerfil(Perfil perfil) {
      this.perfil = perfil;
   }
    

   public String getNome() {
      return this.nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }


}