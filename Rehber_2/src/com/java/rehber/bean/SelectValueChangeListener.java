package com.java.rehber.bean;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

public class SelectValueChangeListener implements ValueChangeListener{

	@Override
	public void processValueChange(ValueChangeEvent event)
			throws AbortProcessingException {
		System.out.println("I am here SelectValueChangeListener");
	}

}
