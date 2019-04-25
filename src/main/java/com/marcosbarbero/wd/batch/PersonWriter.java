package com.marcosbarbero.wd.batch;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.batch.item.ItemWriter;

public class PersonWriter implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> items) throws Exception {
		for (String item : items) {
			System.out.println(item);
			Thread.sleep(TimeUnit.SECONDS.toMillis(3));
		}
		
	}
    
}