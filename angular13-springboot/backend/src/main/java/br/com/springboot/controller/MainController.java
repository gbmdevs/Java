package br.com.springboot.controller;

import br.com.springboot.entity.Estudante;
import br.com.springboot.service.EstudanteService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Controller;

import java.util.List;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;


import org.springframework.beans.factory.annotation.Autowired;  

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.Job;


@RestController
@RequestMapping("/api")
public class MainController{
     @Autowired
     JobLauncher jobLauncher;
 
     //@Autowired
     //Job processJob;
     
     @Autowired
     EstudanteService estudanteService;

     // Area de Transferencia de Arquivos
     @PostMapping("/cargastock")
     public String carregaArquivosStock(@RequestParam("files") MultipartFile[] files){
        System.out.println("Tamanho dos Arquivos: " + files.length);
        System.out.println("Entrou na Carga das Stocks");
        
        String arquivo = "arquivo_base";
        int contador;
        
        try{
        // Caminho absoluto dos arquivos
            for(contador = 0;contador<files.length;contador++){
                byte[] bytes = files[contador].getBytes();
                String pathRoot = new File("").getAbsolutePath();
                System.out.println("Path:" + pathRoot );
                File dir = new File(pathRoot + File.separator + "tmpFiles");
                if(!dir.exists()){
                    dir.mkdirs();
                }
                File serverFile = new File(dir.getAbsolutePath() + File.separator + arquivo + "_" + contador+ ".csv" );
                BufferedOutputStream stream =  new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
            }

            return  "Arquivo subiu com sucesso! - Total de Arquivos: " + contador;
        }catch(Exception ex){
           ex.printStackTrace();
           return "Falha ocorrida no upload do arquivo. Arquivo vazio.";
        }       

     }

     //List
     @GetMapping("/estudantes")
     public List<Estudante> getAllEstudantes(){ 
          System.out.println("Entrou no estudantes");
          return estudanteService.getAllEstudantes();
     }

     //Insert
     @PostMapping("/estudante")
     private int salvarEstudante(@RequestBody Estudante estudante){
          estudanteService.saveOrUpdate(estudante);
          return estudante.getId();
     }

    /* Invocar o job
    @RequestMapping("/invokejob")
    public void handle() throws Exception {
 
        JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                    .toJobParameters();
        jobLauncher.run(processJob, jobParameters);
 
        //return "Batch job has been invoked";
        System.out.println("Rodou o JOB");
    } */
}