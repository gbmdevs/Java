package br.banco.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.nio.charset.StandardCharsets;

import org.json.JSONArray;
import org.json.JSONObject;

import br.banco.json.JsonBasico;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class CarregarTabelas{
        

    public <T> void carregarTabela(String arquivo, Class<T> classe){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("planilha-funcional");
        EntityManager entityManager = entityManagerFactory.createEntityManager(); 
        entityManager.getTransaction().begin(); 

        InputStream is = this.getClass().getClassLoader().getResourceAsStream(arquivo);
        
        if(is == null){
            throw new IllegalArgumentException("Arquivo não encontrado!");
        }

        try(InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader)){
            StringBuilder sb = new StringBuilder();
            String linha;
            while((linha = reader.readLine()) != null){
                System.out.println(linha);
                sb.append(linha+"\n");
            }

            //jsonToObjeto(classe,sb.toString());

            JSONObject jsonObject = new JSONObject(sb.toString());
            JSONArray jarray = jsonObject.getJSONArray("dados");
            String tamanho  = String.valueOf(jarray.length());
            System.out.println("Tamanho: " + tamanho);

            for(int i = 0; i< jarray.length(); i++){
                  System.out.println("("+i+"): " + jarray.getJSONObject(i));
                  jsonToObjeto(classe,jarray.getJSONObject(i).toString());
            }   
        }catch(IOException io){            
            io.printStackTrace();
            throw new IllegalArgumentException("Ocorreu um erro na leitura");
        }


        entityManager.close();
        entityManagerFactory.close();
    }


    // Captura o JSON para uma classse Genérica
    public <T> void jsonToObjeto(Class<T> type, String json){
         System.out.println("String recebida: " + json);
         GsonBuilder gson = new GsonBuilder();
         Type collectionType = new TypeToken<JsonBasico<T>>(){}.getType();
         JsonBasico<T> jsonBasico = gson.create().fromJson(json, collectionType);
         System.out.println("Saida JSOn object: " + jsonBasico.getDados());
    }

}