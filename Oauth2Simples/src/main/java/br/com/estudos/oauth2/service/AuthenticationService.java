package br.com.estudos.oauth2.service;

import org.springframework.stereotype.Service;
import br.com.estudos.oauth2.repository.UsuarioRepository;
import br.com.estudos.oauth2.model.Usuario;
import br.com.estudos.oauth2.dto.login.LoginUserDTO;

import org.springframework.security.core.userdetails.UsernameNotFoundException;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthenticationService{

    private final UsuarioRepository userRepository;

    public AuthenticationService(UsuarioRepository userRepository){
        this.userRepository=userRepository;
    }

    public Usuario authenticate(LoginUserDTO input) {
         log.info("Authenticar = {}",input);
         return userRepository.findByEmail(input.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}