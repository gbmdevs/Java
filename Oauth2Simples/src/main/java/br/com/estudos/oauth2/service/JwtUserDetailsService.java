package br.com.estudos.oauth2.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;


import org.springframework.security.core.userdetails.User;
import br.com.estudos.oauth2.model.Usuarios;
import br.com.estudos.oauth2.repository.UsuariosRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class JwtUserDetailsService implements UserDetailsService {
      
      @Autowired
      private UsuariosRepository usuarioRepo;

      @Override
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        System.out.println("Entrou no 1");
        Usuarios usuario = usuarioRepo.findByName(username);
        return new User("email@teste.com.br","askdhadjkhasjdas",new ArrayList<>());
      }
}