package br.com.estudo.oauth;


//Pacotes base para a incialização do Spring boot
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootAppStart{

    public static void main(String[] args) {
		SpringApplication.run(SpringBootAppStart.class, args);
	}
}