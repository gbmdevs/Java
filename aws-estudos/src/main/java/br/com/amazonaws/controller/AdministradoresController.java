package br.com.amazonaws.controller;

import java.util.List;

import br.com.amazonaws.model.Administrador;
import br.com.amazonaws.repository.AdministradoresRepo;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdministradoresController
{

  @Autowired
  private AdministradoresRepo repo;

  @GetMapping("/administradores")
  public String index(Model model){
    List<Administrador> administradores = (List<Administrador>)repo.findAll();
    model.addAttribute("administradores", administradores);
    return "administradores/index";
  }

}