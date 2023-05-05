package br.com.estudos.oauth2.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.estudos.oauth2.repository.UsuarioRepository;
import br.com.estudos.oauth2.model.Usuario;

@Service
public class UsuarioRegistrationService{
    
    private UsuarioRepository repository;

    public Usuario register(Usuario usuario){
       return repository.save(usuario);
    }
    
}