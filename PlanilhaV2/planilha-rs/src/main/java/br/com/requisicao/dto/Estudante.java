package br.com.requisicao.dto;

import java.util.List;

public class Estudante{

    private String nome;
    private List<Professores> professores;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}