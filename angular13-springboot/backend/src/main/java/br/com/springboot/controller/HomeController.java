package br.com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/crisis-list")
public class HomeController {
       @GetMapping
       public String home() {
              System.out.println("Entrou na home");
              return "forward:/index.html";
       }
}