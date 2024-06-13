package br.com.estudos.oauth2.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.estudos.oauth2.service.UsarioAuthenticationService;
import br.com.estudos.oauth2.service.UsuarioRegistrationService;
import br.com.estudos.oauth2.service.TokenService;
import br.com.estudos.oauth2.dto.DadosLoginDTO;
import br.com.estudos.oauth2.dto.UsuarioResponseDTO;
import br.com.estudos.oauth2.dto.UsuarioAutenticadoDTO;
import br.com.estudos.oauth2.dto.UsuarioRegistrationDTO;
import br.com.estudos.oauth2.model.Usuario;

import br.com.estudos.oauth2.dto.auth.*;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController{

    @Autowired
    UsarioAuthenticationService usuarioAuthService;

    @Autowired
    UsuarioRegistrationService usuarioRegisterService;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public void autenticar(@RequestBody DadosLoginDTO dadosLogin){
        System.out.println("Logando");
    }

    @PostMapping("/user")
    public String registrar(@RequestBody UsuarioRegistrationDTO dadosRegistro){
        System.out.println(dadosRegistro.toString());
        //Usuario usuario = usuarioRegisterService.register(dadosRegistro.toUser());
        usuarioRegisterService.register(dadosRegistro.toUser());
        //return new ResponseEntity<UsuarioAutenticadoDTO>(UsuarioAutenticadoDTO.toDTO(usuario, "Bearer "),HttpStatus.CREATED);
        return "Strubg";
    }


    @PostMapping("/authenticate")
    public void createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        System.out.println("Entrou na função");
    }


}