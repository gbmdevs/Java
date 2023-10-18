package br.com.estudos.oauth2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.estudos.oauth2.model.StocksUserOperations;

import br.com.estudos.oauth2.service.UserResumeService;
import br.com.estudos.oauth2.service.ViewdeTesteService;


import org.springframework.beans.factory.annotation.Autowired;

import br.com.estudos.oauth2.dto.ResumePositionsStocks;
import br.com.estudos.oauth2.dto.ResumeInvestmentBalance;
import br.com.estudos.oauth2.utils.ExportToExcelFile;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import br.com.estudos.oauth2.model.ViewDeTeste;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/user-resume")

public class UserResumeController{

    @Autowired
    private  UserResumeService userResumeService;

    @Autowired
    private ViewdeTesteService viewDetesteService;

    @GetMapping(value = "/stocks-positions")
    public List<ResumePositionsStocks> returnListUserStockPositions(){
        return userResumeService.buscarPosicoesUsuario();
    }

    @GetMapping(value ="/investment/balance")
    public List<ResumeInvestmentBalance> returnInvestmentbalance(){
        return userResumeService.returnInvestimentBalance();
    }

    @GetMapping(value="export")
    public ResponseEntity<byte[]> export(){
        List<ResumePositionsStocks> lista =  userResumeService.buscarPosicoesUsuario();
        List<ViewDeTeste> lista2 = viewDetesteService.findAll();
        return new ResponseEntity<>(ExportToExcelFile.writeToExcel("teste", lista ),HttpStatus.OK);
    }

}