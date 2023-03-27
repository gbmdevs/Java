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

  private String[] URLS_WHITELIST = {
     "/authenticate",
     "/signup",
     "/h2-console/**"
  };

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
     .authorizeRequests().antMatchers(URLS_WHITELIST).permitAll()
     // Qualquer outra requisição deve ser checada
     .anyRequest().authenticated().and()
     .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement();
     
     //fix H2 database console: Refused to display ' in a frame because it set 'X-Frame-Options' to 'deny'
     httpSecurity.headers().frameOptions().sameOrigin();
  }

}