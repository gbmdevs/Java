package br.com.amazonaws;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;

/**
 * Hello world!
 *
 */
@Controller
public class HelloController
{

    @GetMapping("/")
    public String index(Model model){
        System.out.println("Entrou aqui! Index");
        return "login/index";
    }

}
    
