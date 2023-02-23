package br.com.estudo.oauth.repository;

import br.com.estudo.oauth.model.SegurancaAPI;
import br.com.estudo.oauth.model.Usuario;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface SegurancaRepositorio extends CrudRepository<SegurancaAPI,Long>{


      SegurancaAPI findByUsuario(Usuario usuario);
}