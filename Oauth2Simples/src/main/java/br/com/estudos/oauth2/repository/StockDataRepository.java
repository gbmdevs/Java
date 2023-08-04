package br.com.estudos.oauth2.repository;

import br.com.estudos.oauth2.model.StocksData;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface StockDataRepository extends CrudRepository<StocksData,Long>{


   @Query("SELECT sd.valueClose FROM StocksData sd WHERE sd.stocks.id = '8ea3e3c5-b419-469d-a9b3-5e46abdc97dc' "+
            "and sd.dateClose = ( select max(sd2.dateClose) from StocksData sd2 where sd2.stocks.id = '8ea3e3c5-b419-469d-a9b3-5e46abdc97dc')")
   Object[] findMaxDateCloseAndMaxValueClose();

}