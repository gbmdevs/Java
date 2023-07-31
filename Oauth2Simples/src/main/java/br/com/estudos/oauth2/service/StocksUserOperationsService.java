package br.com.estudos.oauth2.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.estudos.oauth2.repository.StocksUserOperationsRepository;
import br.com.estudos.oauth2.model.StocksUserOperations;
import java.util.List;

@Service
public class StocksUserOperationsService{

    @Autowired
    private StocksUserOperationsRepository repository;


    public List<StocksUserOperations> returnAllStocksOperations(){
        return repository.findAll();
    }
   

}