package br.com.jacocomvctest.controller;

import br.com.jacocomvctest.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.jacocomvctest.service.ProdutoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController{
    
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/produtos")
    public List<Produto> getProdutos(){
        return produtoService.getProdutos();
    }

}