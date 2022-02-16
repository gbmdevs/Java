package br.estudo.JUnit.api;

import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.lang.StringBuilder;
import java.io.InputStreamReader;


import com.fasterxml.jackson.databind.ObjectMapper;

import br.estudo.JUnit.json.HistoricoAtivo;

public class DadosMercadoFinanceiro{

     private static String URL_HISTORICO_MERCADO = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=BBAS3.SAO&apikey=H2PVC2B6ERK6RIMY";

    public DadosMercadoFinanceiro(){

    }

    public void buscarDadosHistoricoAtivo(){
        try{
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
        System.out.println(sb.toString());
        }catch(MalformedURLException ex){
            ex.printStackTrace();
        }catch(IOException ioex){
            ioex.printStackTrace();
        }
    }

}