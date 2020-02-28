package Planilha.Controller;

import Planilha.Model.Empregados; 

// Bibliotecas a respeito do Spring Framework 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import java.util.ArrayList;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MainController{
    private List<Empregados> empregados = criarLista();

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public List<Empregados> primeriaPage(){
             System.out.println("Hello");
             return empregados;
    }
 
    private static List<Empregados> criarLista(){
        List<Empregados> tempEmpregados = new ArrayList<>();
        Empregados emp1 = new Empregados();
        emp1.setNome("Jamal");
        emp1.setSalario(15666.08);

        tempEmpregados.add(emp1);
        return tempEmpregados;
    }


}