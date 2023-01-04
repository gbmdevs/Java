package br.com.estudo.oauth;


//Pacotes base para a incialização do Spring boot
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class SpringBootAppStart{

    public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-3:00"));
		SpringApplication.run(SpringBootAppStart.class, args);
		
	}
}