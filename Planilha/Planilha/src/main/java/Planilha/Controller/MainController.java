package Planilha.Controller;

// Models
import Planilha.Model.Empregados; 
import Planilha.Model.Gastos;

// Controllers
import Planilha.Controller.GastosController;

// Bibliotecas a respeito do Spring Framework 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

// Jackson
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.ArrayList;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RestController
public class MainController{
    private List<Empregados> empregados = criarLista();
    private List<Gastos> spent  = criarGastos();
    private GastosController gastos = new GastosController();
    


    //Rotas
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public List<Empregados> primeriaPage(){
             System.out.println("Hello");
             return empregados;
    }


    @RequestMapping(value="/gastos", method = RequestMethod.GET, produces = "application/json")
    public GastosController listaGastos(){    
        ObjectMapper mapper = new ObjectMapper();



        System.out.println("Gastos GET Realizado!");
        List<Gastos> TempGast = new ArrayList<>();
        TempGast.add(new Gastos(1,"Teste ", 165.00));
          
        gastos.setTotalSpent(160.00);
        gastos.setGastos(TempGast);

       // String jsonString = mapper.writeValueAsString(gastos);
         
        System.out.println(jsonString);

        return gastos;
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
 
 public  static List<Gastos> criarGastos(){
    List<Gastos> tempGastos = new ArrayList<>();
    Gastos gas1 = new Gastos();
    Gastos gas2 = new Gastos();       
    Integer id  = 0 ;

    gas1.setSpentDescription("Descrição Simples do Gastos");
    gas1.setSpentValue(1678.56);
    gas1.setId(id + 1);

    gas2.setSpentDescription("Descrição Simples 2");
    gas2.setSpentValue(878.45);
    gas2.setId(id + 2);

    tempGastos.add(gas1);
    tempGastos.add(gas2);
    return tempGastos;

}


 

}