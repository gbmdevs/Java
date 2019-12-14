package Financeiro.Controller;

// Spring MVC
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// Postgres
import Financeiro.Controller.DBConfig;

@Controller
public class MainController{


@RequestMapping(value = "/", method = RequestMethod.GET)
  public String main(){
      DBConfig db = new DBConfig();
      db.testaConexao(); 
      return "index";
  }

}