package Financeiro.Controller;

// Spring MVC
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Postgres
import Financeiro.Controller.DBConfig;

@Controller
public class MainController{


@RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView main() throws SQLException{
      
      DBConfig db = new DBConfig();
      db.conexao(); 
      
      // Constitui os atributos que a pagina ira receber
      ModelAndView modelo = new ModelAndView("index");      
      modelo.addObject("db",db.status);

      List<String> listaTabelas =  db.listarTabelas();
      modelo.addObject("lista",listaTabelas);

      return modelo;
  }

}