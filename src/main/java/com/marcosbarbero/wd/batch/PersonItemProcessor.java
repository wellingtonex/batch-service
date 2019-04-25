package com.marcosbarbero.wd.batch;

import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {		
		return item.toUpperCase();
	}

    

}