package com.allianz.training.pattern;

import java.util.concurrent.Callable;

public class CallObject implements Callable<String>{

	@Override
	public String call() throws Exception {
		return "test";
	}

}
