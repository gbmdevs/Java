package br.com.estudos.oauth2.service;

import br.com.estudos.oauth2.dto.ResumeBalance;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.estudos.oauth2.repository.BalanceRepository;

import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;
import java.util.UUID;


@Service
public class BalanceService{

    @Autowired
    private BalanceRepository repository;

    public List<ResumeBalance>  sumBalanceByTypeBalance(){
        return repository.sumBalanceByTypeBalance();
    }

    public BigDecimal findAvailableBalanceByTypeBalance(UUID id){
        return repository.findAvailableBalanceByTypeBalance(id);
    }
    

}