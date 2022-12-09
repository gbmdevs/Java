package br.com.estudo.oauth.repository;

import br.com.estudo.oauth.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepositorio extends CrudRepository<Usuario,Long>{

    

}