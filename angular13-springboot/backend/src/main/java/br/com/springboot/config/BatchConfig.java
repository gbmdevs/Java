package br.com.springboot.config;


// Area reservada para o processamento batch Spring
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;

// Classes Internas
import br.com.springboot.listener.JobCompletionListener;
import br.com.springboot.step.Processor;
import br.com.springboot.step.Reader;
import br.com.springboot.step.Writer;


//@Configuration
public class BatchConfig{

    @Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

    @Bean
	public Job processJob() {
		return jobBuilderFactory.get("processJob")
				.incrementer(new RunIdIncrementer()).listener(listener())
				.flow(orderStep1()).end().build();
	}

    @Bean
	public Step orderStep1() {
		return stepBuilderFactory.get("orderStep1").<String, String> chunk(1)
				.reader(new Reader()).processor(new Processor())
				.writer(new Writer()).build();
	}

    @Bean
	public JobExecutionListener listener() {
		return new JobCompletionListener();
	}

}