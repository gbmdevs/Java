
package br.com.estudos.oauth2.utils;

import java.io.Serializable;

import java.util.Map;
import java.util.HashMap;
import java.util.function.Function;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtTokenUtil implements Serializable{ 

    private static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    @Value("${jwt.secret}")
    private String secret;

    //retorn o Username do token JWT
    public String getUsernameFromToken(String token){
        return getClaimFromToken(token, Claims::getSubject);
    }

    //retorna expiration  date do token JWT
    public Date getExpirationDateFromToken(String token){
        return getClaimFromToken(token, Claims::getExpiration);
    }


    public <T> T getClaimFromToken(String token, Function<Claims,T> claimsResolver){
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    public void generateToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<>();
    }

    //Para retornar qualquer informação do token nos iremos precisar da secret key
    private Claims getAllClaimsFromToken(String token){
        return Jwts.parser()
                   .setSigningKey(secret)
                   .parseClaimsJws(token)
                   .getBody();
    }

    // Valida o token
    

}