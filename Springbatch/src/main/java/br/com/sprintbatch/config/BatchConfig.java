package br.com.sprintbatch.config;

import br.com.sprintbatch.reader.Reader;
import br.com.sprintbatch.processor.Processor;
import br.com.sprintbatch.writer.Writer;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;

@Configuration
public class BatchConfig{

    @Autowired
	private JobBuilderFactory jobFactory;

	@Autowired
	private StepBuilderFactory stepFactory;

    @Bean
	public Step hellowWorldStep() {
		return stepFactory.get("readJsonStep").<String, String>chunk(1).reader(new Reader()).processor(new Processor())
				.writer(new Writer())
				.allowStartIfComplete(true)
				.build();
	}

	@Bean
	public Job helloWorldJob() {
		return jobFactory.get("helloworld").flow(hellowWorldStep()).end().build();
	}

}