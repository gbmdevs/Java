package br.com.amazonaws.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import br.com.amazonaws.service.CookieService;

@Controller
public class HomeController
{
    @GetMapping("/")
    public String index(Model model,  HttpServletRequest request) throws UnsupportedEncodingException{
        
        if(CookieService.getCookie(request, "nomeUsuario") == null){
            return "redirect:/login";
        }
        model.addAttribute("nome", CookieService.getCookie(request, "nomeUsuario"));
        System.out.println("Entrou aqui! Home Index");
        return "home/index";
    }

}
    
