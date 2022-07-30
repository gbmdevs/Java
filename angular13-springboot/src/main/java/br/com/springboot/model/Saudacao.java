package br.com.springboot.model;


public class Saudacao{

    private final long id;
    private final String conteudo;

    public Saudacao(Long id, String conteudo) {
		this.id = id;
		this.conteudo = conteudo;
	}

    public long getId() {
        return this.id;
    }

    public String getConteudo() {
        return this.conteudo;
    }
    

}