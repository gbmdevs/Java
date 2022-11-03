package br.com.jacocomvctest.controller;

import br.com.jacocomvctest.controller.APIController;
import br.com.jacocomvctest.model.Produto;
import br.com.jacocomvctest.service.ProdutoService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class APIControllerTest{

    @InjectMocks
    private APIController apiController;

    @Mock
    private ProdutoService produtoService;

    @AfterEach
    public void tearDown() {
        Mockito.reset(produtoService);
    }

    @Test
    public void buscarCaminhoProdutos(){
        List<Produto> produtos = apiController.getProdutos();
    }

}