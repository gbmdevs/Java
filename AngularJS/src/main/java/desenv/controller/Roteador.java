package desenv.controller;

import desenv.model.Cliente;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

// Area de Banco de Dados
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;

@Controller
public class Roteador
{
    @RequestMapping(value="/",method=RequestMethod.GET)
    public String executa(){
          System.out.println("Pagina inicial requisitada!");
          
          try {
           Connection connection =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "");
             System.out.println("Foi");
          }catch(SQLException ex){
                System.out.println("Deu ruim na conexão");
            }

            
          
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
    @RequestMapping(value="/users/{name}",method=RequestMethod.GET)
    public @ResponseBody Cliente getClienteJSON(@PathVariable String name){
       String json = "";      
       Cliente cli = new Cliente();
       cli.setNome(name);
       return cli;
    }

}
