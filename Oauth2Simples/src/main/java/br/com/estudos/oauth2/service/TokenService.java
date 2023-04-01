package br.com.estudos.oauth2.service;

import org.springframework.stereotype.Service;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

@Service
public class TokenService {

    //30 Minutos de Expiracao
    private static  final long expirationTime = 1800000;

    private static  final String segredo = "teste em segredo";

    public String generateToken(){
        return Jwts.builder()
                   .setIssuedAt(new Date(System.currentTimeMillis()))
                   .setSubject("Test JWT API")
                   .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                   .signWith(SignatureAlgorithm.HS256, segredo)
                   .compact();
    }

}