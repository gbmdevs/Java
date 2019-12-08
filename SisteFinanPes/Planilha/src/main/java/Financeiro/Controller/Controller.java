package Financeiro.Controller;

// Spring MVC
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//@Controller
public class Controller{
   
@RequestMapping(value = "/", method = RequestMethod.GET)
  public String main(String model){
      System.out.println(model);
      return "main";
  }



}