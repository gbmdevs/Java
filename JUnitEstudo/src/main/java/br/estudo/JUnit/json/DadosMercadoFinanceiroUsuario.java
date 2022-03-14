package br.estudo.JUnit.json;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class DadosMercadoFinanceiroUsuario {
    private String nome;
    private Double valor;
    private List<HistoricoAtivo> historico;

    public DadosMercadoFinanceiroUsuario(){

    }

    public DadosMercadoFinanceiroUsuario(String nome, Double valor){
        this.nome  = nome;
        this.valor = valor;
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return this.valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
