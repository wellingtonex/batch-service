package com.marcosbarbero.wd.batch;

import org.springframework.batch.item.support.IteratorItemReader;

public class PersonItemReader extends IteratorItemReader<String> {

	public PersonItemReader(Iterable<String> iterable) {
		super(iterable);
	}
	
	

}
