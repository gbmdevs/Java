package desenv.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.annotation.Validated;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Roteador
{
    @RequestMapping(value="/",method=RequestMethod.GET)
    public String executa(){
          System.out.println("Pagina inicial requisitada!");
          return "index";
    }
    @RequestMapping(value="/listaSimples",method=RequestMethod.GET)
    public ModelAndView listaSimples(){
          System.out.println("Entrou na lista Simples!");         
          ArrayList<String> lista = new ArrayList();
          System.out.println(lista);
          lista.add("Jamal1");
          ModelAndView modelo = new ModelAndView("listaSimples");
          modelo.addObject("lista",lista);
          return modelo;
    }
    // Estudos de JSON  - Forma de Retorno para angular
    @RequestMapping()

}
