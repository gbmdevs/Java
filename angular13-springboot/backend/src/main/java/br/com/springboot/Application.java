package br.com.springboot;

// SpringBoot Dependencias
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.ApplicationContext;

// Spring Web
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
//@EnableBatchProcessing
public class Application{
    
    public static void main(String[] args) { 

         ApplicationContext ctx = SpringApplication.run(Application.class, args);

    }
}