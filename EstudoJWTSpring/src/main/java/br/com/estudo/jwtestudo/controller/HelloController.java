package br.com.estudo.jwtestudo.controler;

// Import da API de requisição
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController{
   
   @RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}


}