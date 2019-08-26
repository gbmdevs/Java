package com.desenvolvimento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

@Controller
public class OlaMundoController {
   @RequestMapping("/olaMundoSpring")
   public String execute(){
       System.out.println("Executando à lógica com Spring MVC");
       return "ok"; 
   }

   @RequestMapping("/teste")
   public String executa(){
       System.out.println("Execucao de teste apenas para ver");
       return "teste"; 
   }
}