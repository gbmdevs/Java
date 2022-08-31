package br.com.springboot.config;


// Area reservada para o processamento batch Spring
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.support.RunIdIncrementer;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;

import br.com.springboot.process.CoffeeItemProcessor;
import org.springframework.batch.core.StepContribution;

// Classes Internas
import br.com.springboot.listener.JobCompletionListener;

import br.com.springboot.step.Processor;
import br.com.springboot.step.Reader;
import br.com.springboot.step.Writer;


@Configuration
@EnableBatchProcessing
public class BatchConfig{

    @Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	//@Value("${file.input}")
    //private String fileInput;

	private static int count = 0;

	@Bean
	public CoffeeItemProcessor processor(){
		return new CoffeeItemProcessor();
		
	}

    @Bean
	public Job job(){
		return this.jobBuilderFactory.get("JobSimples").start(step()).build();
	}

	// Passo 1
	@Bean
	public Step step(){
	   return  this.stepBuilderFactory.get("Passo01").tasklet(new Tasklet() {
          @Override
		  public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext){
			  System.out.println(count + ". Hello World");
			  count++;
			   if (count < 5) {
					return RepeatStatus.CONTINUABLE;
			   } else {
					return RepeatStatus.FINISHED;
			   }
		  }
 
	   }).build();
	}

}