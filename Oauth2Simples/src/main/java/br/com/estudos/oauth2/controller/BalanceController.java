package br.com.estudos.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.estudos.oauth2.service.BalanceService;
import br.com.estudos.oauth2.dto.ResumeBalance;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/balance")
public class BalanceController{

     @Autowired
     private BalanceService service;

     @GetMapping(value = "/user-resume")
     public List<ResumeBalance> findSumAllBalanceUser(){
         return service.sumBalanceByTypeBalance();
     }


}
