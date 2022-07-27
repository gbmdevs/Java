package br.com.amazonaws.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import br.com.amazonaws.repository.AdministradoresRepo;
import br.com.amazonaws.model.Administrador;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.amazonaws.service.CookieService;

@Controller
public class LoginController{

   @Autowired
   private AdministradoresRepo repo;

   //Pagina de Login principal
   @GetMapping("/login")
   public String index(){
     return "login/index";
   }

   @PostMapping("/logar")
   public String logar(Model model, Administrador admParam, String lembrar, HttpServletResponse response) throws IOException{
       
       Administrador adm = this.repo.Login(admParam.getEmail(), admParam.getSenha()); 
       System.out.println("Email - : " + adm.getEmail());
       if(adm != null){
            int tempoLogado = (60*60); // 1 hora de cookie
            if(lembrar != null) tempoLogado = (60*60*24*365); // 1 ano de cookie
               CookieService.setCookie(response, "usuarioId", String.valueOf(adm.getId()), tempoLogado);
               CookieService.setCookie(response, "nomeUsuario", String.valueOf(adm.getNome()), tempoLogado);
               return "redirect:/";
       }     
       model.addAttribute("erro", "Usuário ou senha inválidos");
       return "login/index";
   }




}