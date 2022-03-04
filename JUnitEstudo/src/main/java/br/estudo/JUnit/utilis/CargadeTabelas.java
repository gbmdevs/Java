package br.estudo.JUnit.utilis;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.json.JSONArray;
import org.json.JSONObject;

import br.estudo.JUnit.entidade.BolsaDeValores;

public class CargadeTabelas {
    

    public void carregaTabelsInternas(){
        System.out.println("Entrou na Carga!");
        System.out.println(this.getClass().getResource("").getPath());
        EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("junit-estudo");
        EntityManager entityManager = entityManagerFactory.createEntityManager(); 
          
        entityManager.getTransaction().begin();  

        //Pegar o arquivo
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("cargaPapeis.json");

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
            JSONArray jarray = jsonObject.getJSONArray("papeis");
            for(int i = 0; i< jarray.length(); i++){
                BolsaDeValores bolsa = new BolsaDeValores();
                bolsa.setNomeTicket(jarray.getJSONObject(i).getString("nomeTicket"));
                bolsa.setDescricaoTicket(jarray.getJSONObject(i).getString("descricao"));
                bolsa.setNomeBalcao(jarray.getJSONObject(i).getString("nomeBalcao"));
                entityManager.persist(bolsa);
            }

            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();
        }catch(IOException io){
            io.printStackTrace();
        }
    }

}
