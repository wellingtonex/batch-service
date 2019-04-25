package com.marcosbarbero.wd.batch;

import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		System.out.println("Thread Name: " +  Thread.currentThread().getName() + " Thread ID " +  Thread.currentThread().getId());
		return item.toUpperCase();
	}

    

}