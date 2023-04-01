package br.com.estudos.oauth2.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.estudos.oauth2.model.Usuario;


import br.com.estudos.oauth2.repository.UsuarioRepository;
import br.com.estudos.oauth2.dto.DadosLoginDTO;

import br.com.estudos.oauth2.exception.ExistingEmailException;

@Service
public class UsarioAuthenticationService{
    
    @Autowired
    UsuarioRepository usuarioRepo;

    public Usuario authenticate(DadosLoginDTO dadosLogin){
       Usuario usuario = usuarioRepo.findByEmail(dadosLogin.getEmail()).orElseThrow(ExistingEmailException::new);
       return usuario;
    }
     
     
}