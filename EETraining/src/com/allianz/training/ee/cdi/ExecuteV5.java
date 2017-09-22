package com.allianz.training.ee.cdi;

import java.io.Serializable;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Any;

@Alternative
// @ExecuteQualifier
public class ExecuteV5 implements IExecute,Serializable{

	@Override
	public String execute() {
		return "V5";
	}

}
