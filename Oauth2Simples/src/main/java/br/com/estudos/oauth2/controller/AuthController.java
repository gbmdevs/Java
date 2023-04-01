package br.com.estudos.oauth2.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;


import br.com.estudos.oauth2.service.UsarioAuthenticationService;
import br.com.estudos.oauth2.service.TokenService;
import br.com.estudos.oauth2.dto.DadosLoginDTO;
import br.com.estudos.oauth2.dto.UsuarioResponseDTO;
import br.com.estudos.oauth2.dto.UsuarioAutenticadoDTO;
import br.com.estudos.oauth2.model.Usuario;

@RestController
public class AuthController{

    @Autowired
    UsarioAuthenticationService usuarioAuthService;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<UsuarioAutenticadoDTO> autenticar(@RequestBody DadosLoginDTO dadosLogin){
        Usuario usuario = usuarioAuthService.authenticate(dadosLogin);
        System.out.println(tokenService.generateToken());
        return new ResponseEntity<UsuarioAutenticadoDTO>(UsuarioAutenticadoDTO.toDTO(usuario, "Bearer "),HttpStatus.CREATED);
    }

}