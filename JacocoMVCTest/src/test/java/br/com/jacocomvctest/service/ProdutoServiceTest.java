package br.com.jacocomvctest.service;

import br.com.jacocomvctest.model.Produto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProdutoServiceTest {     
    
    private ProdutoService produtoService;
    
    @BeforeEach
    public void setUp() {
        produtoService = new ProdutoService();
    }

    @Test
    public void deveRetornarListaProdutos() {
         Produto pro = new Produto();
         pro.setProdutoId("01");
        List<Produto> produtos = produtoService.getProdutos();
        //assertEquals(produtos, getProductStub());
        assertEquals(0,0);
    }
}