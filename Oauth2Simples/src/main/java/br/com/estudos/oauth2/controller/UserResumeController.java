package br.com.estudos.oauth2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.estudos.oauth2.model.StocksUserOperations;

import br.com.estudos.oauth2.service.StocksUserOperationsService;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/user-resume")

public class UserResumeController{

    @Autowired
    private StocksUserOperationsService serviceUserOperations;

    @GetMapping(value = "/stocks-positions")
    public List<StocksUserOperations> returnListUserStockPositions(){
        return serviceUserOperations.returnAllStocksOperations();
    }


}