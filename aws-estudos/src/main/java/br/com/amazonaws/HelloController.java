package br.com.amazonaws;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@RestController
public class HelloController
{

    @GetMapping("/")
    public String index(){
        return "Pagina retornada :)";
    }

}
    
