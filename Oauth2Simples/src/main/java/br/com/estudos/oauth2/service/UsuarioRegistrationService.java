package br.com.estudos.oauth2.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.estudos.oauth2.repository.UsuarioRepository;
import br.com.estudos.oauth2.model.Usuario;

@Service
public class UsuarioRegistrationService{
    
    @Autowired
    private UsuarioRepository repository;

    public void register(Usuario usuario){
       usuario.toString();
       //usuario.setUUID("10bc86a2-02e5-11ee-be56-0242ac120002");
       repository.save(usuario);
    }
    
}