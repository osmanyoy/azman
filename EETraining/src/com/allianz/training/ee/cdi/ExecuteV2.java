package com.allianz.training.ee.cdi;

import java.io.Serializable;

import javax.enterprise.inject.Any;
import javax.inject.Named;

@Named
@Any
public class ExecuteV2 implements IExecute,Serializable{

	@Override
	public String execute() {
		return "V2";
	}

}
