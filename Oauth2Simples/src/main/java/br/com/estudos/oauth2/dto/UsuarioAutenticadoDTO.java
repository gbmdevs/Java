package br.com.estudos.oauth2.dto;

import br.com.estudos.oauth2.model.Usuario;

public class UsuarioAutenticadoDTO { 

    private String nome;
    private String email;
    private String token;
    private String tipo;

    public UsuarioAutenticadoDTO(String email, String nome, String token, String tipo){
        this.nome  = nome;
        this.email = email;
        this.token = token;
        this.tipo  = tipo;
    }

    public static UsuarioAutenticadoDTO toDTO(Usuario usuario, String tipo){
        return new UsuarioAutenticadoDTO(usuario.getEmail(),usuario.getNome(),usuario.getToken(), tipo);
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

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }



}