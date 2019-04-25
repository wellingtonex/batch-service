package com.marcosbarbero.wd.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class AutobotWriter implements ItemWriter<Autobot> {

	@Override
	public void write(List<? extends Autobot> items) throws Exception {
		for (Autobot autobot : items) {
			System.out.println(autobot);
		}
		
	}

    
}