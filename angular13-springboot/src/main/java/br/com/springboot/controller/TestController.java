package br.com.springboot.controller;

import br.com.springboot.model.Saudacao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController{
     @GetMapping("/")
     public Saudacao index(){
         return new Saudacao(1L,"Teste");
     }
}