package com.marcosbarbero.wd.batch;

import org.springframework.batch.item.support.IteratorItemReader;

public class AutobotItemReaderIterator extends IteratorItemReader<Autobot> {

	public AutobotItemReaderIterator(Iterable<Autobot> iterable) {
		super(iterable);
	}
	
	

}