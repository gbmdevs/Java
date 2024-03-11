package br.com.sprintbatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;


@EnableBatchProcessing
@SpringBootApplication
public class SpringBatchApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(SpringBatchApp.class, args);
    }
}
