package Financeiro.Controller;

// Spring MVC
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// Postgres
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@Controller
public class MainController{
    // Variaveis do DB
     String driver = "org.postgresql.Driver";
     String user   = "postgres";
     String pass   = "";
     String url    = "jdbc:postgresql://localhost:5432/postgres"; 
     Connection con = null;    

@RequestMapping(value = "/", method = RequestMethod.GET)
  public String main(){
       
       try{
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,pass);
            System.out.println("Banco de Dados Conectado");
       }catch(Exception e){
            System.out.println(e);
       }      

      return "index";
  }



}