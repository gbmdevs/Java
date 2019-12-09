package Financeiro.Controller;

// Spring MVC
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import Financeiro.Configuration.ConfigServer;

@Controller
public class MainController{
   
@RequestMapping(value = "/", method = RequestMethod.GET)
  public String main(){
      System.out.println("Bora Galera!");
      return "index";
  }



}