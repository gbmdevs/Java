package br.com.springboot.repository;

import org.springframework.data.repository.CrudRepository;  

// Modelo
import br.com.springboot.model.Estudante;

public interface EstudanteRepository extends CrudRepository<Estudante, Integer>{

}