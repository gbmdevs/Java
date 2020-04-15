package Planilha.Controller;

// Models
import Planilha.Model.Empregados;
import Planilha.Model.Gastos;
import Planilha.Model.Staff;
import Planilha.Model.Profile;

// Controllers
import Planilha.Controller.GastosController;

// Bibliotecas a respeito do Spring Framework 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

// Jackson
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
// Bibliotecas Padrões
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Arrays;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


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

    @RequestMapping(value="/gastos", method = RequestMethod.GET, produces= "application/json")
    public String listagastos() throws SQLException{
        Profile      pf1     = new Profile();
        String       jsonRet =  ""; 
        List<Gastos> gas1    = new ArrayList<Gastos>();
        ObjectMapper mapper  = new ObjectMapper();
        GastosController gasCon  = new GastosController();
         

        gas1 = gasCon.buscaGastos(); 
        System.out.println(gas1);
        
        pf1.setTotalSalaryAcc(14.55);
        pf1.setSpents(gas1);

        // Monta JSON de Resposta
        try{
         jsonRet = mapper.writeValueAsString(pf1);
        }catch(IOException e ){
           e.printStackTrace();
        }
        
        return jsonRet;
    }

    @RequestMapping(value="/staff", method = RequestMethod.GET, produces = "application/json")
    public String listaStaf(){    
        TimeZone.setDefault(TimeZone.getTimeZone("GMT-03:00"));
        Locale.setDefault(new Locale("pt", "BR"));
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); 
        
        System.out.println(c.getTime().toString());  

        System.out.println("GET REALIZADO: " + sdf.format(data)); 
        ObjectMapper mapper = new ObjectMapper();
        Staff staff = createStaff();
        String jsonString = "";
        // Conversao para Json
        try { 
          jsonString = mapper.writeValueAsString(staff); 
          

        }catch(IOException e){
             e.printStackTrace();
        }

        return jsonString;
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


// Area de Teste Remover Depois

public static Staff createStaff(){
     Staff staff = new Staff();
     
     staff.setName("Jamal Braga");
     staff.setAge(25);
     staff.setPosition(
         new String[]{"Aluno","Iniciante"});
     staff.setSkills(Arrays.asList(
         "Java","React","Angular"
      ));
     Map<String, BigDecimal> salary = new HashMap() {{
         put("2010", new BigDecimal(1000));
         put("2015", new BigDecimal(4500));
     }};

     staff.setSalary(salary);

     return staff;
}

 

}