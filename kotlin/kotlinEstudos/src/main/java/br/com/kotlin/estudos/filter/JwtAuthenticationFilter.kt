package br.com.kotlin.estudos.filter 

import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.web.servlet.HandlerExceptionResolver
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.web.authentication.WebAuthenticationDetails
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import lombok.extern.slf4j.Slf4j
import lombok.NonNull
import br.com.kotlin.estudos.services.JwtService

@Component
@Slf4j
class JwtAuthenticationFilter(
       private val handlerExceptionResolver: HandlerExceptionResolver,
       private val jwtService: JwtService,
       private val userDetailsService: UserDetailsService
    ): OncePerRequestFilter(){
    
    override fun doFilterInternal(@NonNull     request: HttpServletRequest,
                         @NonNull    response: HttpServletResponse,
                         @NonNull filterChain: FilterChain ){    
        val authHeader: String? = request.getHeader("Authorization")  
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }             
        try {
            val jwt: String = authHeader.substring(7)
            val userEmail: String = jwtService.extractUsername(jwt)
            val authentication: Authentication? = SecurityContextHolder.getContext().getAuthentication()
            if(userEmail != null && authentication == null){
                val userDetails = userDetailsService.loadUserByUsername(userEmail)
                if(jwtService.isTokenValid(jwt, userDetails)){
                    val authToken = UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.authorities
                    )
                    authToken.details = WebAuthenticationDetailsSource().buildDetails(request)
                    SecurityContextHolder.getContext().authentication = authToken
                }
            }
            filterChain.doFilter(request, response)
        }catch(ex: Exception){
            println(ex)
            handlerExceptionResolver.resolveException(request, response, null, ex);
        }
    }

}