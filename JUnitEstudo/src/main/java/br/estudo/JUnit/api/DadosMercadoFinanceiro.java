package br.estudo.JUnit.api;

import java.net.URLConnection;
import java.util.Iterator;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.lang.StringBuilder;
import java.io.InputStreamReader;
import java.text.ParseException;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.util.JSONPObject;

import br.estudo.JUnit.json.HistoricoAtivo;
import br.estudo.JUnit.entidade.HistoricoBolsaValores;
import br.estudo.JUnit.entidade.BolsaDeValores;

import br.estudo.JUnit.dao.HistoricoBolsaValoresDao;

import java.text.SimpleDateFormat;  
import java.util.Date;

import java.math.BigDecimal;

public class DadosMercadoFinanceiro{

     private static String URL_HISTORICO_MERCADO = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=";
     private static String CHAVE_DA_API="&apikey=H2PVC2B6ERK6RIMY";

     public HistoricoBolsaValoresDao histbolsadao;

    public DadosMercadoFinanceiro(){

    }

    public void buscarDadosHistoricoAtivo(BolsaDeValores bolsavalores){
        
        String urlPesquisa = URL_HISTORICO_MERCADO+bolsavalores.getNomeTicket()
                             +"."+bolsavalores.getNomeBalcao()+CHAVE_DA_API;
        System.out.println(urlPesquisa);
        try{
        HistoricoAtivo historicoAtivo = new HistoricoAtivo();
        URL url = new URL(urlPesquisa);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");
        InputStream responseStream = connection.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        String linha;
        BufferedReader br = new BufferedReader(new InputStreamReader(responseStream));
        StringBuilder sb = new StringBuilder();
        while ((linha = br.readLine()) != null) {
                    sb.append(linha+"\n");
        }
        br.close();
        //System.out.println(sb.toString());
    
        // Tratamento do Json em si
        JSONObject jsonObject = new JSONObject(sb.toString());
        JSONObject jsonChildObject = (JSONObject)jsonObject.get("Time Series (Daily)");
        Iterator iterator  = jsonChildObject.keys();
        String key = null;
        Integer dias = 0;
        while(iterator.hasNext()){
            HistoricoBolsaValores histBolsaVal = new HistoricoBolsaValores();
            key = (String)iterator.next();
            Date dataFechamento = new SimpleDateFormat("yyyy-mm-dd").parse(key);
            histBolsaVal.setDataFechamento(dataFechamento);
            histBolsaVal.setBolsadevalores(bolsavalores);
            histBolsaVal.setAbertura(new BigDecimal(0));
            histBolsaVal.setMaxima(new BigDecimal(0));
            histBolsaVal.setMinima(new BigDecimal(0));
            histBolsaVal.setFechamento(new BigDecimal(0));
            System.out.println("Insercao: " + histBolsaVal.toString());
            histbolsadao.inserirHistoricoBolsaValores(histBolsaVal);
            //System.out.println("Fechamento ("+key+"): "+((JSONObject)jsonChildObject.get(key)).get("4. close"));
            dias++;
        }


        System.out.println("Total de Dias:" +dias);
        }catch(MalformedURLException ex){
            ex.printStackTrace();
        }catch(IOException ioex){
            ioex.printStackTrace();
        }catch(ParseException pe){
            pe.printStackTrace();
        }
    }

}