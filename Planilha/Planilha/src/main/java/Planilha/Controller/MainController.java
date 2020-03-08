package Planilha.Controller;

import Planilha.Model.Empregados; 

// Bibliotecas a respeito do Spring Framework 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MainController{
    private List<Empregados> empregados = criarLista();
    

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void testaPost(){
        System.out.println("Enviou o Post");
    }

    //Rotas
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public List<Empregados> primeriaPage(){
             System.out.println("Hello");
             return empregados;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void testePost(){
           System.out.println("Post Realizado!");

    }

    // Funcoes das Rotas 
    private static List<Empregados> criarLista(){
        List<Empregados> tempEmpregados = new ArrayList<>();
        Empregados emp1 = new Empregados();
        emp1.setNome("Jamal");
        emp1.setSalario(7688.56);
        emp1.setCargo("Analista Jr");

        Empregados emp2 = new Empregados();
        emp2.setNome("Lais Gois");
        emp2.setSalario(7688.56);
        emp2.setCargo("Designer Pleno");

        Empregados emp3 = new Empregados();
        emp3.setNome("Funalo de Tal");
        emp3.setSalario(1200.00);
        emp3.setCargo("Estagiario");

        tempEmpregados.add(emp1);
        tempEmpregados.add(emp2);
        tempEmpregados.add(emp3);
        return tempEmpregados;
    }

 

}