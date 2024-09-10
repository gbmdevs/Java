package br.com.kotlin.estudos.services;

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.security.core.userdetails.UserDetails
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.Claims
import java.security.Key
import lombok.extern.slf4j.Slf4j
import java.util.Date

import io.jsonwebtoken.SignatureAlgorithm


@Service
class JwtService{

    @Value("\${security.jwt.secret-key}")
    private lateinit var secretKey: String

    @Value("\${security.jwt.expiration-time}")
    private var jwtExpiration: Long = 0 

    fun isTokenValid(token: String, userDetails: UserDetails): Boolean{
        val username = extractUsername(token)
        return (username == userDetails.username) && !isTokenExpired(token)
    }

    fun isTokenExpired(token: String): Boolean{
        println("Entrou no expirado")
        return extractExpiration(token).before(Date())
    }

    private fun extractExpiration(token: String): Date {
        return extractClaim(token, Claims::getExpiration)
    }

    fun extractUsername(token: String): String{
        return extractClaim(token, Claims::getSubject)
    }

    fun <T> extractClaim(token: String, claimsResolver: (Claims) -> T): T{
         val claims: Claims = extractAllClaims(token)
         return claimsResolver(claims) 
    }

    fun generateToken(userDetails: UserDetails): String {
        return generateToken(emptyMap(), userDetails)
    }
    
    fun generateToken(extraClaims: Map<String, Any>, userDetails: UserDetails): String {
        return buildToken(extraClaims, userDetails, jwtExpiration)
    }

    private fun buildToken(
          extraClaims: Map<String, Any>,
          userDetails: UserDetails,
          expiration: Long
    ): String {
       return Jwts.builder()
           .setClaims(extraClaims)
           .setSubject(userDetails.username)
           .setIssuedAt(Date(System.currentTimeMillis()))
           .setExpiration(Date(System.currentTimeMillis() + expiration))
           .signWith(getSignInKey(), SignatureAlgorithm.HS256)
           .compact()
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

    fun getJwtExpiration(): Long{
        return jwtExpiration
    }

}