package br.com.jacocomvctest.service;

import br.com.jacocomvctest.model.Produto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class ProdutoService{

    public List<Produto> getProdutos(){
        List<Produto> lista = new ArrayList<Produto>();        
        return lista;
    }

}