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

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.util.JSONPObject;

import br.estudo.JUnit.json.HistoricoAtivo;

public class DadosMercadoFinanceiro{

     private static String URL_HISTORICO_MERCADO = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=BBAS3.SAO&apikey=";
     private static String CHAVE_DA_API="H2PVC2B6ERK6RIMY";

    public DadosMercadoFinanceiro(){

    }

    public void buscarDadosHistoricoAtivo(){
        try{
        HistoricoAtivo historicoAtivo = new HistoricoAtivo();
        URL url = new URL(URL_HISTORICO_MERCADO);
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
            key = (String)iterator.next();
            //System.out.println("Fechamento ("+key+"): "+((JSONObject)jsonChildObject.get(key)).get("4. close"));
            dias++;
        }


        System.out.println("Total de Dias:" +dias);
        }catch(MalformedURLException ex){
            ex.printStackTrace();
        }catch(IOException ioex){
            ioex.printStackTrace();
        }
    }

}