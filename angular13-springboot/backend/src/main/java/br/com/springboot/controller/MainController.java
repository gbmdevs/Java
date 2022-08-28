package br.com.springboot.controller;

import br.com.springboot.entity.Estudante;
import br.com.springboot.service.EstudanteService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

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
    // @Autowired
    // JobLauncher jobLauncher;
 
    // @Autowired
    // Job processJob;
     
     @Autowired
     EstudanteService estudanteService;

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