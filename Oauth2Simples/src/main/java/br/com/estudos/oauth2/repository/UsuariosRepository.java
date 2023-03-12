package br.com.estudos.oauth2.repository;

import br.com.estudos.oauth2.model.Usuarios;
import org.springframework.data.repository.CrudRepository;

public interface UsuariosRepository extends CrudRepository<Usuarios,Long>{

   Usuarios findByName(String nome);

}