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
import br.com.estudos.oauth2.service.StocksService;

import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;


@RestController
@CrossOrigin
@RequestMapping(value = "/stocks")
public class StockController{

    @Value("${url.retrieve.stocks.data}")
    private String url;

    @Autowired
    private StocksService service;

    @GetMapping
    public List<Stocks> findAllStockTickets(){
        return service.findAll();
    }

    @GetMapping(value = "/retrivedata")
    public void loadDataStocksinDBspecificDate(@RequestParam(required = false) String dataInicio,
                                               @RequestParam(required = false) String dataFinal,
                                               @RequestParam(required = false) String ticket){

        System.out.println("Entrou na carga" + dataInicio + "," + dataFinal);
        changeDateToUnixTimeStamp(dataInicio);
        changeDateToUnixTimeStamp(dataFinal);

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url+ticket+"?")
        .queryParam("period1", changeDateToUnixTimeStamp(dataInicio))
        .queryParam("period2", changeDateToUnixTimeStamp(dataFinal))
        .queryParam("interval", "1d")
        .queryParam("events", "history")
        .queryParam("includeAdjustedClose", "true");

        System.out.println(builder.toUriString());

        try{
           InputStream inputStream = new URL(builder.toUriString()).openStream();
           InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
           CSVFormat format = CSVFormat.DEFAULT.builder().setHeader().setDelimiter(',')
           .setSkipHeaderRecord(true).build();
           CSVParser csvParser = new CSVParser(reader,format);

           for(CSVRecord record : csvParser){
              System.out.println(record.get(0) +","+ record.get(1)+","+ record.get(2)+","+ record.get(3));
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