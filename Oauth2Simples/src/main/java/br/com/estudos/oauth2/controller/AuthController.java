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
import br.com.estudos.oauth2.service.AuthenticationService;
import br.com.estudos.oauth2.service.jwt.JwtService;
import br.com.estudos.oauth2.service.TokenService;  
import br.com.estudos.oauth2.dto.login.LoginUserDTO;
import br.com.estudos.oauth2.dto.login.LoginResponse;
import br.com.estudos.oauth2.model.Usuario;

import br.com.estudos.oauth2.dto.auth.*;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@RequestMapping("/auth")
@Slf4j
public class AuthController{
 
    private final AuthenticationService authenticationService;
    private final JwtService jwtService;

    public AuthController( AuthenticationService authenticationService,JwtService jwtService) {
        this.authenticationService = authenticationService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> autenticar(@RequestBody LoginUserDTO login){
        log.info("Entrou no login: {}",login);
        Usuario user = authenticationService.authenticate(login);
        String jwtToken = jwtService.generateToken(user);
        log.info("Usuario= {} Token = {}",user,jwtToken);
        LoginResponse loginResponse = new LoginResponse(jwtToken,jwtService.getJwtExpiration());
        return ResponseEntity.ok(loginResponse);
    }
/*
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
    }*/


}