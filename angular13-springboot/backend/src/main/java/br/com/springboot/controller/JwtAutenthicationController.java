package br.com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date; 

// JWT Libs para Java
import io.jsonwebtoken.*;

@RestController
public class JwtAutenthicationController {

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public void createAuthenticationToken(){
        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        System.out.println("Entrou no authenticate");

    }

}