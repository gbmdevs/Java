package br.com.estudos.oauth2.controller;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(value = "/retrivedata")
    public void loadDataStocksinDBspecificDate(@RequestParam(required = false) String dataInicio,
                                               @RequestParam(required = false) String dataFinal,
                                               @RequestParam(required = false) String ticket){

        System.out.println("Entrou na carga" + dataInicio + "," + dataFinal);
        
        Optional<Stocks> stock = service.findByTicket(ticket);

        String urlConcat = stock.get().getTicket() + "." +
                           stock.get().getRegion() +"?";

        changeDateToUnixTimeStamp(dataInicio);
        changeDateToUnixTimeStamp(dataFinal);

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url+urlConcat)
            .queryParam("period1", changeDateToUnixTimeStamp(dataInicio))
            .queryParam("period2", changeDateToUnixTimeStamp(dataFinal))
            .queryParam("interval", "1d")
            .queryParam("events", "history")
            .queryParam("includeAdjustedClose", "true");

        System.out.println(builder.toUriString());

        SimpleDateFormat formatar = new SimpleDateFormat("yyyy-MM-dd");

        try{
           InputStream inputStream = new URL(builder.toUriString()).openStream();
           InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
           CSVFormat format = CSVFormat.DEFAULT.builder().setHeader().setDelimiter(',')
           .setSkipHeaderRecord(true).build();
           CSVParser csvParser = new CSVParser(reader,format);

           for(CSVRecord record : csvParser){
             try{
              System.out.println(record.get(0) +","+ record.get(1)+","+ record.get(2)+","+ record.get(3)+","
                                 + record.get(4)+","                                 
                                 + record.get(5)+","
                                 + record.get(6));
              StocksData stockdata = new StocksData();
              Date dataClose = formatar.parse(record.get(0));
              stockdata.setStocks(stock.get());
              stockdata.setDateClose(dataClose);
              stockdata.setOpen(new BigDecimal(record.get(1)));
              stockdata.setValueClose(new BigDecimal(record.get(3)));
              stockdata.setAdjClose(new BigDecimal(record.get(5)));
              serviceStockData.createStockData(stockdata);   
             }catch(Exception ex){
                 System.out.println("Caiu na exception");
             }          
           }

           csvParser.close();
           reader.close();
        }catch(IOException ex){
           ex.printStackTrace();
        }
    }


    public long changeDateToUnixTimeStamp(String data){
        long epochTime = 0;
        try{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date      = sdf.parse(data);
        epochTime = date.getTime() / 1000;
        System.out.println("Data "+epochTime);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return epochTime;

    }

}