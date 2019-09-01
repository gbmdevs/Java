package Desenv;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.annotation.Validated;

@Controller
public class Roteador
{
    @RequestMapping(value="/",method=RequestMethod.GET)
    public String executa(){
          System.out.println("Pagina inicial requisitada!");
          return "index";
    }
    @RequestMapping(value="/listaSimples",method=RequestMethod.GET)
    public String listaSimples(){
          System.out.println("Entrou na lista Simples!");         
          ArrayList<String> lista = new ArrayList();
          lista.add("Jamal1");
          return "listaSimples";
    }
}
