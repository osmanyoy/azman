package com.allianz.training.ee.rest;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

public class CustomerConfig {

	@Produces
	@Default
	public CheckEmployee checkEmployee() {
		CheckEmployee checkEmployee = new CheckEmployee();
		return checkEmployee;
	}
}
