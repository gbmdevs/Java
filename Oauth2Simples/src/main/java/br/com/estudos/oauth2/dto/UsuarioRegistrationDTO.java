package br.com.estudos.oauth2.dto;

import br.com.estudos.oauth2.model.Usuario;

public class UsuarioRegistrationDTO{

    private String nome;
    private String email;
    private String senha;

    public Usuario toUser(){
        return new Usuario(getNome(),getEmail(),getSenha());
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


}