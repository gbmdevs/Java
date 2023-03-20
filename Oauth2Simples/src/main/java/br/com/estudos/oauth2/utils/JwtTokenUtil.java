
package br.com.estudos.oauth2.utils;

import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtTokenUtil { 

    private static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    @Value("${jwt.secret}")
    private String secret;

    public void generateToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<>();
    }

}