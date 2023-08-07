package br.com.estudos.oauth2.repository;

import br.com.estudos.oauth2.model.StocksData;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.math.BigDecimal;
import br.com.estudos.oauth2.model.Stocks;

@Repository
public interface StockDataRepository extends CrudRepository<StocksData,Long>{


   @Query("SELECT sd.valueClose FROM StocksData sd WHERE sd.stocks = :stocks "+
            " and sd.dateClose = ( select max(sd2.dateClose) from StocksData sd2 where sd2.stocks = :stocks )")
   BigDecimal findMaxDateCloseAndMaxValueClose(@Param("stocks") Stocks stocks);

}