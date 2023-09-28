package br.com.estudos.oauth2.controller;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.util.UriComponentsBuilder;

import org.springframework.beans.factory.annotation.Value;

import java.net.URL;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.IntStream;

import br.com.estudos.oauth2.model.Stocks;
import br.com.estudos.oauth2.model.StocksData;
import br.com.estudos.oauth2.service.StocksService;
import br.com.estudos.oauth2.service.StocksDataService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.text.SimpleDateFormat;
import java.math.BigDecimal;

@RestController
@CrossOrigin
@RequestMapping(value = "/stocks")
public class StockController{

    @Value("${url.retrieve.stocks.data}")
    private String url;

    @Autowired
    private StocksService service;

    @Autowired
    private StocksDataService serviceStockData;

    @GetMapping
    public List<Stocks> findAllStockTickets(){
        return service.findAll();
    }

    @PostMapping(value="/loadall")
    public void loadAllMetaData(){
        List<Stocks> stocks = service.findAll();
        IntStream.range(0,stocks.size()).forEach(i -> {
              serviceStockData.loadDataStocksinDBspecificDate("2022-05-01","2999-12-31",stocks.get(i).getTicket());
        });
    }

    @GetMapping(value = "/retrivedata")
    public void loadDataStocksinDBspecificDate(@RequestParam(required = false) String dataInicio,
                                               @RequestParam(required = false) String dataFinal,
                                               @RequestParam(required = false) String ticket){
        
        Optional<Stocks> stock = service.findByTicket(ticket);
        serviceStockData.loadDataStocksinDBspecificDate(dataInicio,dataFinal,stock.get().getTicket());

    } 
 

}