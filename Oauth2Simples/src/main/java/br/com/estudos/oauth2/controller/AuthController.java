package br.com.estudos.oauth2.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.estudos.oauth2.model.Usuarios;
import br.com.estudos.oauth2.repository.UsuariosRepository;

@RestController
public class AuthController{

    @Autowired
    UsuariosRepository usuariorepo;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam("nome")  String nome){
        
        Usuarios usuario = usuariorepo.findByName(nome);

        if(usuario == null){
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(usuario);          
    }
}