package br.estudo.JUnit.utilis;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class CargadeTabelas {
    

    public void carregaTabelsInternas(){
        System.out.println("Entrou na Carga!");
        System.out.println(this.getClass().getResource("").getPath());

        //Pegar o arquivo
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("test1.json");

        if(is == null){
            throw new IllegalArgumentException("Arquivo não encontrado!");
        }


        try(InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader)){

            String linha;
            while((linha = reader.readLine()) != null){
                System.out.println(linha);
            }

        }catch(IOException io){
            io.printStackTrace();
        }
    }

}
