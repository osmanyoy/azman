package com.allianz.training.pattern;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) throws Exception {
		
//		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
//		
//		for (int i = 0; i < 1_000; i++) {
//			newFixedThreadPool.execute(new ObjectRunnable());
//		}
//		
//		CallObject callObject = new CallObject();
//		
//		Future<String> submit = newFixedThreadPool.submit(callObject);
//		// .....
//		if (submit.isDone()) {
//			String string = submit.get();
//		}
//		String string = submit.get(10_000L,TimeUnit.MILLISECONDS);
//		
		for (int i = 0; i < 5; i++) {
			TestObject testObject = new TestObject();
			testObject.start();
		}	
		try {
			Thread.sleep(3_000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(TestObject.counter);
		System.out.println(TestObject.atomicLong.get());
	}
}
