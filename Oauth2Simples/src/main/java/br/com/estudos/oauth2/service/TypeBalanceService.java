package br.com.estudos.oauth2.service;

import br.com.estudos.oauth2.model.TypeBalance;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.estudos.oauth2.repository.TypeBalanceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TypeBalanceService{


    @Autowired
    private TypeBalanceRepository repository;

    
    public List<TypeBalance> findAllByBroker(){
        return repository.findAllByBroker();
    }


}