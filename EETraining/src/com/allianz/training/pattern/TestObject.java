package com.allianz.training.pattern;

import java.util.concurrent.atomic.AtomicLong;

public class TestObject extends Thread {
	public static long counter;
	public static AtomicLong atomicLong = new AtomicLong();

	public static synchronized void inc() {
		counter++;
	}

	@Override
	public void run() {
		// for (int i = 0; i < 1_000_000; i++) {
		// inc();
		// atomicLong.incrementAndGet();
		// }
		while (true) {
			try {
				counter++;
				if (counter % 1_000_000 == 0) {
					Thread.sleep(1);
				}
			} catch (Exception e) {
			}
		}
	}
}
