package com.allianz.training.ee.ejb;

import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Stateless;


@LocalBean
@Stateless
public class AsyncEJB {
	
	@Asynchronous
	public Future<String> hello() {
		try {
			Thread.sleep(4_000L);
		} catch (InterruptedException e) {
		}
		return new AsyncResult<String>("hello");
	}
	
	@Schedule(hour="*",minute="*",second="*/30",persistent=false)
	public void timer() {
		System.out.println("timer calisti");
	}
}
