package br.com.estudos.oauth2.dto;

import br.com.estudos.oauth2.model.Usuario;

public class UsuarioResponseDTO {
     private String nome;
     private String email;

     public UsuarioResponseDTO(){

     }

     public UsuarioResponseDTO(String nome, String email){
        this.nome  = nome;
        this.email = email;
     }

     public static UsuarioResponseDTO toDTO(Usuario usuario, String token){
           return new UsuarioResponseDTO(usuario.getNome(),usuario.getEmail());
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


}