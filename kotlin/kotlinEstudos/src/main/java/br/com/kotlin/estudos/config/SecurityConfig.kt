package br.com.kotlin.estudos.config

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import br.com.kotlin.estudos.filter.JwtAuthenticationFilter
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig(private val jwtAuthenticationFilter: JwtAuthenticationFilter){

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain{
        http.csrf().disable()
            .headers().frameOptions().disable().and() //Para o H2Console
            .authorizeRequests().antMatchers("/auth/**").permitAll()
            .antMatchers("/h2-console/**").permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter::class.java)
        return http.build()
    }

}


