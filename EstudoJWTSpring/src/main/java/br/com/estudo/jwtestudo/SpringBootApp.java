package br.com.estudo.jwtestudo;


//Pacotes base para a incialização do Spring boot
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootApp{

    public static void main(String[] args) {
		SpringApplication.run(SpringBootApp.class, args);
	}
}