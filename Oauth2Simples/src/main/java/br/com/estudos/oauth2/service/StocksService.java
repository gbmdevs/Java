package br.com.estudos.oauth2.service;

import br.com.estudos.oauth2.model.Stocks;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.estudos.oauth2.repository.StocksRepository;

import java.util.List;

@Service
public class StocksService{


    @Autowired
    private StocksRepository repository;

    
    public List<Stocks> findAll(){
        return repository.findAll();
    }

}