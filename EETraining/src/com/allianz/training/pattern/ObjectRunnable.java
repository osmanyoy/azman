package com.allianz.training.pattern;

import java.util.concurrent.atomic.AtomicLong;

public class ObjectRunnable implements Runnable{

	private static AtomicLong AtomicLong = new AtomicLong();
	
	@Override
	public void run() {
		System.out.println("test : " + AtomicLong.incrementAndGet());
	}

}
