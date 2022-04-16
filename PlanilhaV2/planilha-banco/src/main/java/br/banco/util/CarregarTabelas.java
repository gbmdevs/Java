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

public class CarregarTabelas{
        

    public void carregarTabela(String arquivo){
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("planilha-funcional");
        EntityManager entityManager = entityManagerFactory.createEntityManager(); 
        entityManager.getTransaction().begin(); 
        System.out.println("Passou");

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
            System.out.println("Sb completo " + sb.toString());

            JSONObject jsonObject = new JSONObject(sb.toString());
            JSONArray jarray = jsonObject.getJSONArray("dados");
            String tamanho  = String.valueOf(jarray.length());
            System.out.println("Tamanho: " + tamanho);
        }catch(IOException io){            
            io.printStackTrace();
            throw new IllegalArgumentException("Ocorreu um erro na leitura");
        }


        entityManager.close();
        entityManagerFactory.close();
    }
}