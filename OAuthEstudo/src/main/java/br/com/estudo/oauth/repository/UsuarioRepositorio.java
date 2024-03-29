package br.com.estudo.oauth.repository;

import br.com.estudo.oauth.model.Usuario;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepositorio extends CrudRepository<Usuario,Long>{

     @EntityGraph(value = "perfil.permissoes", type = EntityGraph.EntityGraphType.FETCH)
     Usuario findByLogin(String login);

     @EntityGraph(value = "perfil.permissoes", type = EntityGraph.EntityGraphType.FETCH)
     Usuario findByLoginAndSenha(String login, String senha);

}