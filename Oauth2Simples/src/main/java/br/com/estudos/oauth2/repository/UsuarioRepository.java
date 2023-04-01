package br.com.estudos.oauth2.repository;

import java.util.Optional;

import br.com.estudos.oauth2.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Long>{

     Optional<Usuario> findByEmail(String email);

}