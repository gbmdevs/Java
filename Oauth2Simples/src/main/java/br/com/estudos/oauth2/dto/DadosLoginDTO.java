package br.com.estudos.oauth2.dto;


public class DadosLoginDTO {
     private String email;
     private String senha;

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