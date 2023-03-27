package br.com.estudos.oauth2.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;



import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.estudos.oauth2.model.Usuarios;
import br.com.estudos.oauth2.repository.UsuariosRepository;


import br.com.estudos.oauth2.model.JwtRequest;

@RestController
@CrossOrigin
public class AuthController{

    @Autowired
    UsuariosRepository usuariorepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(){
        return ResponseEntity.badRequest().body("Error: Usuario ja existente");
    }

    @RequestMapping(value="/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToke(@RequestBody JwtRequest authenticationRequest) throws Exception{
        authenticate(authenticationRequest.getUsername(),authenticationRequest.getPassword());
        //Usuarios usuario = usuariorepo.findByName(authenticationRequest.getUsername());
        System.out.println("Entrou aqui!");
        return ResponseEntity.ok("Pronto");
        
    }

    private void authenticate(String username, String password) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch(DisabledException e){
            throw new Exception("USER_DISABLED",e);
        }

    }
}