package br.com.kotlin.estudos.services;

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.Claims;
import java.security.Key
import lombok.extern.slf4j.Slf4j

@Service
class JwtService{

    @Value("\${security.jwt.secret-key}")
    private lateinit var secretKey: String

    fun extractUsername(token: String): String{
        return extractClaim(token, Claims::getSubject)
    }

    fun <T> extractClaim(token: String, claimsResolver: (Claims) -> T): T{
         val claims: Claims = extractAllClaims(token)
         return claimsResolver(claims) 
    }

    private fun extractAllClaims(token: String): Claims {
        return Jwts.parserBuilder()
           .setSigningKey(getSignInKey())
           .build()
           .parseClaimsJws(token)
           .body
    }

    private fun getSignInKey(): Key{
        val keyBytes = Decoders.BASE64.decode(secretKey)
        return Keys.hmacShaKeyFor(keyBytes)
    }

}