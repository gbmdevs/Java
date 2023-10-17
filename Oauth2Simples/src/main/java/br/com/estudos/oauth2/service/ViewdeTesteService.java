package br.com.estudos.oauth2.service;

import br.com.estudos.oauth2.dto.ResumeBalance;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.estudos.oauth2.repository.BalanceRepository;
import br.com.estudos.oauth2.repository.ViewDeTesteRepository;

import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;
import java.util.UUID;

import br.com.estudos.oauth2.model.ViewDeTeste;

@Service
public class ViewdeTesteService{

    @Autowired
    private ViewDeTesteRepository repository;

    public List<ViewDeTeste>  findAll(){
        return repository.findAll();
    }
    

}