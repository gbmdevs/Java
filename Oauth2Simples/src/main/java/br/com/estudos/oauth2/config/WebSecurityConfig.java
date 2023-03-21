package br.com.estudos.oauth2.config;


import br.com.estudos.oauth2.config.JwtAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;


import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

  @Autowired
  private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

  @Autowired
  private UserDetailsService jwtUserDetailsService;

  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception{
      return super.authenticationManagerBean();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
       auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
  }

@Bean
public PasswordEncoder passwordEncoder() {
return new BCryptPasswordEncoder();
}

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
     httpSecurity.csrf().disable()
     //Não checa essas requisições
     .authorizeRequests().antMatchers("/authenticate").permitAll()
     // Qualquer outra requisição deve ser checada
     .anyRequest().authenticated().and()
     .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement();
  }

}