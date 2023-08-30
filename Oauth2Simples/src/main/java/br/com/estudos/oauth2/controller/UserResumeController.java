package br.com.estudos.oauth2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.estudos.oauth2.model.StocksUserOperations;

import br.com.estudos.oauth2.service.UserResumeService;


import org.springframework.beans.factory.annotation.Autowired;

import br.com.estudos.oauth2.dto.ResumePositionsStocks;
import br.com.estudos.oauth2.dto.ResumeInvestmentBalance;

import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/user-resume")

public class UserResumeController{

    @Autowired
    private  UserResumeService userResumeService;

    @GetMapping(value = "/stocks-positions")
    public List<ResumePositionsStocks> returnListUserStockPositions(){
        return userResumeService.buscarPosicoesUsuario();
    }

    @GetMapping(value ="/investment/balance")
    public List<ResumeInvestmentBalance> returnInvestmentbalance(){
        return userResumeService.returnInvestimentBalance();
    }


}