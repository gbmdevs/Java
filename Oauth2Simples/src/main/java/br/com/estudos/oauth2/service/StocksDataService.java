package br.com.estudos.oauth2.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.estudos.oauth2.repository.StockDataRepository;
import br.com.estudos.oauth2.model.StocksData;
import br.com.estudos.oauth2.model.Stocks;
import java.math.BigDecimal;

@Service
public class StocksDataService{

    @Autowired
    private StockDataRepository repository;


    public void createStockData(StocksData stocskData){
        repository.save(stocskData);
    }

    public BigDecimal findMaxDateCloseAndMaxValueClose(Stocks stock){
        return repository.findMaxDateCloseAndMaxValueClose(stock);
    }

    

}