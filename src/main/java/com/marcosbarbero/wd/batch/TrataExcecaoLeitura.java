package com.marcosbarbero.wd.batch;

import java.util.NoSuchElementException;

import org.springframework.batch.repeat.RepeatContext;
import org.springframework.batch.repeat.exception.ExceptionHandler;

public class TrataExcecaoLeitura implements ExceptionHandler {

	@Override
	public void handleException(RepeatContext context, Throwable throwable) throws Throwable {
		if(throwable instanceof NoSuchElementException) {
			System.out.println("Erro, não fazer nada");
		}

	}

}
