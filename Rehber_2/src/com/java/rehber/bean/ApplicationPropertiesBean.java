package com.java.rehber.bean;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="appBean")
@ApplicationScoped
public class ApplicationPropertiesBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3289329003823512883L;
	private String appName = "JSF Test App";
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
}
