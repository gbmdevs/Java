package br.com.jacocomvctest.model;

public class Produto{
    private String produtoId;
    private String produtoName;
    private Double produtoPreco;

    public String getProdutoId() {
        return this.produtoId;
    }

    public void setProdutoId(String produtoId) {
        this.produtoId = produtoId;
    }

    public String getProdutoName() {
        return this.produtoName;
    }

    public void setProdutoName(String produtoName) {
        this.produtoName = produtoName;
    }

    public Double getProdutoPreco() {
        return this.produtoPreco;
    }

    public void setProdutoPreco(Double produtoPreco) {
        this.produtoPreco = produtoPreco;
    }

}