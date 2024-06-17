package br.com.estudos.oauth2.service.jwt;

import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Value;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Map;
import java.util.Date;
import java.util.HashMap;

@Service
public class JwtService{
    @Value("${security.jwt.secret-key}")
    private String secretKey;

    @Value("${security.jwt.expiration-time}")
    private long jwtExpiration;

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return buildToken(extraClaims, userDetails, jwtExpiration);
    }

    // Construção do JWT com usuario
    private String buildToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails,
            long expiration
    ) {
        return Jwts.builder()   
                   .setClaims(extraClaims)     
                   .setSubject(userDetails.getUsername())
                   .setIssuedAt(new Date(System.currentTimeMillis()))
                   .setExpiration(new Date(System.currentTimeMillis() + expiration))
                   .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                   .compact();
    }

    private Key getSignInKey() { 
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public long getJwtExpiration() {
        return this.jwtExpiration;
    }

}