package br.com.estudo.oauth.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Usuario { 

   @Id
   private Long id;
  
   @NotEmpty
   @Size(min = 1, max = 20)
   @Column(unique = true)
   private String login;

   @NotEmpty
   private String senha;


}