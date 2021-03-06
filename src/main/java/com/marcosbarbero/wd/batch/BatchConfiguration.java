/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.marcosbarbero.wd.batch;

import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;


/**
 * @author Marcos Barbero
 * @since 2018-02-10
 */
@Configuration
@EnableBatchProcessing
public class BatchConfiguration extends DefaultBatchConfigurer {

	//private final JobBuilderFactory jobBuilderFactory;

	//private final StepBuilderFactory stepBuilderFactory;

	//private final DataSource dataSource;

//	public BatchConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
//			DataSource dataSource) {
//		this.jobBuilderFactory = jobBuilderFactory;
//		this.stepBuilderFactory = stepBuilderFactory;
//		this.dataSource = dataSource;
//	}
	
	@Override
    public void setDataSource(DataSource dataSource) {
        // override to do not set datasource even if a datasource exist.
        // initialize will use a Map based JobRepository (instead of database)
    }

//	// tag::readerwriterprocessor[]
//	@Bean
//	public FlatFileItemReader<Autobot> reader() {
//		FlatFileItemReader<Autobot> reader = new FlatFileItemReader<>();
//		reader.setResource(new ClassPathResource("sample-data.csv"));
//		reader.setLineMapper(new DefaultLineMapper<Autobot>() {
//			{
//				setLineTokenizer(new DelimitedLineTokenizer() {
//					{
//						setNames(new String[] { "name", "car" });
//					}
//				});
//				setFieldSetMapper(new BeanWrapperFieldSetMapper<Autobot>() {
//					{
//						setTargetType(Autobot.class);
//					}
//				});
//			}
//		});
//		return reader;
//	}
//	
//	public AutobotItemReaderIterator readerIterator() {
//		
//		
//		Autobot autobot1 = new Autobot("Fiesta", "Fraco");
//		Autobot autobot2 = new Autobot("Focus", "Feio");
//		Autobot autobot3 = new Autobot("Fusion", "Beberrão");
//		Autobot autobot4 = new Autobot("KA", "Nem é carro");
//		Autobot autobot5 = new Autobot("Ranger", "Para quem gosta de aparecer");
//		
//		List<Autobot> autobots = Arrays.asList(autobot1, autobot2, autobot3, autobot4, autobot5);
//		
//		return new AutobotItemReaderIterator(autobots);
//	}
//
//	@Bean
//	public AutobotItemProcessor processor() {
//		return new AutobotItemProcessor();
//	}
//
//	@Bean
//	public JdbcBatchItemWriter<Autobot> writer() {
//		JdbcBatchItemWriter<Autobot> writer = new JdbcBatchItemWriter<>();
//		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
//		writer.setSql("INSERT INTO autobot (name, car) VALUES (:name, :car)");
//		writer.setDataSource(this.dataSource);
//		return writer;
//	}
//	// end::readerwriterprocessor[]
//
//	// tag::jobstep[]
//	@Bean
//	public Job importAutobotJob(JobCompletionNotificationListener listener) {
//		return jobBuilderFactory.get("importAutobotJob").incrementer(new RunIdIncrementer()).listener(listener)
//				.flow(step1()).end().build();
//	}
//
//	@Bean
//	public Step step1() {
//		return stepBuilderFactory.get("step1")
//				.<Autobot, Autobot>chunk(10)
//				.reader(reader())
//				.processor(processor())
//				.writer(writer())
//				.listener(new ItemCountListener())
//				.build();
//	}
//	// end::jobstep[]
}
