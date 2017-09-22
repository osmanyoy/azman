package com.allianz.training.ee.ejb;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

@LocalBean
@Singleton
public class SingletonTest {
	
	private ReentrantReadWriteLock Lock = new ReentrantReadWriteLock();
	
	@Lock(LockType.READ)
	public void method1() {
		ConcurrentHashMap<String, String> test = new ConcurrentHashMap<>(1_000_000,0.9F,1000);
	}
	
	@Lock(LockType.READ)
	public void method2() {
		
	}

	@Lock(LockType.WRITE)
	public void method3() {
		
	}
	
}
