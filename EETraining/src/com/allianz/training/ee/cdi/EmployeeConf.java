package com.allianz.training.ee.cdi;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Named;

public class EmployeeConf {
	
	@Produces
	@Default
	public IExecute createExecuteInterfaceV1() {
		return new ExecuteV1();
	}
	
	@Produces
	@Named("v2")
	public IExecute createExecuteInterfaceV2() {
		return new ExecuteV2();
	}

	@Produces
	@Named("xyz1")
	public IExecute createExecuteInterfaceV3() {
		return new ExecuteV3();
	}

	@Produces
	//@ExecuteQualifier
	@Named("Asd")
	public IExecute createExecuteInterfaceV4(InjectionPoint injectionPoint) {
		System.out.println(injectionPoint.getMember().getDeclaringClass().getName());
		return new ExecuteV3();
	}

	@Produces
	@ExecuteQualifier
	@SessionScoped
	public IExecute createExecuteInterfaceV5() {
		return new ExecuteV3();
	}

}
