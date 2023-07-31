package br.com.estudos.oauth2.repository;

import br.com.estudos.oauth2.model.StocksUserOperations;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

@Repository
public interface StocksUserOperationsRepository extends CrudRepository<StocksUserOperations,Long>{

   List<StocksUserOperations> findAll();

}