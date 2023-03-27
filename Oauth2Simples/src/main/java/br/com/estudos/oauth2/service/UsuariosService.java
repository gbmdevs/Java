
package br.com.estudos.oauth2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import br.com.estudos.oauth2.repository.UsuariosRepository;
import br.com.estudos.oauth2.model.Usuarios;

@Service
public class UsuariosService{
     
     @Autowired
     UsuariosRepository usuarioRepository;

     @Transactional
     public Usuarios findByNameUser(String name){
        System.out.println("Foi aqui");
        return this.usuarioRepository.findByName(name);
     }

      @Transactional
      public void insertIntoUser(Usuarios usuario){
         System.out.println("Inserindo");
      }


}