package com.marcosbarbero.wd.batch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;



@Service
@EnableBatchProcessing
@EnableAsync
@EnableScheduling
public class JobExecuteServce {

	@Autowired
    private JobLauncher jobLauncher;
	
	@Autowired
    public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
    public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	public TaskExecutor taskExecutor;
	
	@PostConstruct
	public void agendar() {
		executar();
	}
    
	@Async
    public void executar() {
    	List<String> nomes = new ArrayList<>();
    	nomes.add("wellington");
    	nomes.add("fulano");
    	nomes.add("beltrano");
    	nomes.add("ze das colves");
    	nomes.add("ciclano");
    	nomes.add("master");
    	nomes.add("simba");
    	
    	Step step1 = step1(new PersonWriter(), nomes);
    	Job job = importUserJob(step1);
    	JobParameters params = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();
        try {
			jobLauncher.run(job, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    
    private PersonItemProcessor processor() {
        return new PersonItemProcessor();
    }

    

    private Job importUserJob(Step step1) {
        return jobBuilderFactory.get("importUserJob")
            .incrementer(new RunIdIncrementer())            
            .flow(step1)
            .end()
            .listener(new JobCompletionNotificationListenerTeste())
            .build();
    }

    
    private Step step1(PersonWriter writer, List<String> nomes) {
        return stepBuilderFactory.get("step1")
            .<String, String> chunk(3)
            .reader(new PersonItemReader(Collections.synchronizedList(nomes)))
            .processor(processor())
            .writer(writer)
            .taskExecutor(taskExecutor)
            .listener(new ItemCountListener())
            .exceptionHandler(new TrataExcecaoLeitura())
//            .throttleLimit(2)
            .build();
    }
	
}
