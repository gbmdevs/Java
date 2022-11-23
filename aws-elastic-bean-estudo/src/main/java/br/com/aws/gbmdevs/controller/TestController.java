package br.com.aws.gbmdevs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController{
    
    @GetMapping("/")
    public String welcome(){
        return "Ola bem vindo ao Gbmdesenvolvimento";
    }
}
