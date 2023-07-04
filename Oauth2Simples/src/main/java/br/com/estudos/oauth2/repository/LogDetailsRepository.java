package br.com.estudos.oauth2.repository;

import java.util.Optional;

import br.com.estudos.oauth2.model.LogDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LogDetailsRepository extends CrudRepository<LogDetails,Long>{
     

}