package br.com.springboot.controller;

import br.com.springboot.model.Estudante;
import br.com.springboot.service.EstudanteService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;  

import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstudanteController{
     
     @Autowired
     EstudanteService estudanteService;

     //List
     @GetMapping("/estudantes")
     public List<Estudante> getAllEstudantes(){ 
          return estudanteService.getAllEstudantes();
     }

     //Insert
     @PostMapping("/estudante")
     private int salvarEstudante(@RequestBody Estudante estudante){
          estudanteService.saveOrUpdate(estudante);
          return estudante.getId();
     }
}