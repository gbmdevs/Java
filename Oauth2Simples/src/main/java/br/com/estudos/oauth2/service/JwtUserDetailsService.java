package br.com.estudos.oauth2.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;


import org.springframework.security.core.userdetails.User;
import br.com.estudos.oauth2.model.Usuarios;
import br.com.estudos.oauth2.service.UsuariosService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class JwtUserDetailsService implements UserDetailsService {
      
      @Autowired
      private UsuariosService userService;

      @Override
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        System.out.println("Entrou no 1");
        Usuarios usuario = userService.findByNameUser(username);
        if(usuario == null){           
            throw new UsernameNotFoundException("Nao achei");
        }
        System.out.println(usuario.getName());
        return new User("email@teste.com.br","askdhadjkhasjdas",new ArrayList<>());
      }
}