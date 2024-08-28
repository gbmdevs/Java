package br.com.kotlin.estudos.filter 

import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.web.servlet.HandlerExceptionResolver
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.FilterChain
import lombok.extern.slf4j.Slf4j
import lombok.NonNull
import br.com.kotlin.estudos.services.JwtService

@Component
@Slf4j
class JwtAuthenticationFilter(
       private val handlerExceptionResolver: HandlerExceptionResolver,
       private val jwtService: JwtService
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
            val jwt: String = authHeader.substring(7);
            val userEmail: String = jwtService.extractUsername(jwt);   
        }catch(ex: Exception){

        }

    }

}