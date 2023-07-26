package br.com.estudos.oauth2.repository;

import br.com.estudos.oauth2.model.StocksData;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface StockDataRepository extends CrudRepository<StocksData,Long>{

}