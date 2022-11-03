package br.com.jacocomvctest.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProdutoTest{

    @Test
    public void getterTest(){
        Produto produto = new Produto();
        produto.setProdutoId("100");
        produto.setProdutoName("Saboneteira");
        produto.setProdutoPreco(3.89);
        assertEquals(produto.getProdutoId(),"100");
        assertEquals(produto.getProdutoName(),"Saboneteira");
        assertEquals(produto.getProdutoPreco(), 3.89);

    }


}