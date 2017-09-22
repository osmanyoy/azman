package com.allianz.training.ee.cdi;

import java.io.Serializable;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;

@Any
public class ExecuteV1 implements IExecute,Serializable{

	@Override
	public String execute() {
		return "V1";
	}

}
