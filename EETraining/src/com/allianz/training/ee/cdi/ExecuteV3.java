package com.allianz.training.ee.cdi;

import java.io.Serializable;

import javax.enterprise.inject.Any;
import javax.inject.Named;

@Any
@Named("xyz")
public class ExecuteV3 implements IExecute,Serializable{
	
	private int execCount = 0;
	
	@Override
	public String execute() {
		return "V3:" + execCount++;
	}

}
