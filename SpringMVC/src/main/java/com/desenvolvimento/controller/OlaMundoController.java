package com.desenvolvimento.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.annotation.Validated;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.*;

import com.desenvolvimento.model.Usuario;

/* Area de Rotas do SpringMVC */
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
  /* Paginação de erro customizada */
   @RequestMapping(value="errors",method = RequestMethod.GET)
   public ModelAndView renderErrorPage(HttpServletRequest httpRequest){
       System.out.println("Entrou no Erro");
       ModelAndView modelo = new ModelAndView("errorPage");
       return modelo;
   } 
   /* Rota para a pagina inicial*/
   @RequestMapping(value="/",method=RequestMethod.GET)
   public String home(Locale locale, Model model){
       System.out.println("Pagina inicial requisitada!");
       Date dataLocal = new Date();
       DateFormat dataFormatada = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
       String dataFinal = dataFormatada.format(dataLocal);
       System.out.println("Data = " + dataFinal); 
      // Passa o Valor para a pagina requsitada 
       model.addAttribute("serverTime",dataFinal);
       return "home";
   }  

   @RequestMapping(value="/user",method=RequestMethod.POST)
   public String usuario(@Validated Usuario usuario, Model modelo){
    System.out.println("Entrou no Usuario ");
    modelo.addAttribute("userName", usuario.getUsuario());
    return "user";

   }
}