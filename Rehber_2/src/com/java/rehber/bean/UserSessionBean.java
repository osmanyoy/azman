package com.java.rehber.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

@ManagedBean(name = "userSession", eager = true)
@SessionScoped
public class UserSessionBean implements Serializable {

	private static final long serialVersionUID = -5912879668545699169L;

	private boolean authedUser = false;
	private String username;
	private String password;
	
	@ManagedProperty(value="#{userBean}")
	private UserManagementBean userManagementBean;

	public boolean isAuthedUser() {
		return authedUser;
	}

	public void setAuthedUser(boolean authedUser) {
		this.authedUser = authedUser;
	}

	public void checkedLogin(ComponentSystemEvent systemEvent) {
		if (!authedUser) {
			FacesContext currentInstance = FacesContext.getCurrentInstance();
			ConfigurableNavigationHandler navigationHandler = (ConfigurableNavigationHandler) currentInstance
					.getApplication().getNavigationHandler();
			navigationHandler.performNavigation("login.xhtml");
		}
	}
	
	public String loginUser(){
		List<User> userList = userManagementBean.getUserList();
		for (User user : userList) {
			if (user.getUsername() != null){
				if (user.getUsername().equals(username)){
					if (user.getPassword() != null && user.getPassword().equals(password)){
						authedUser = true;
						return "success";
					}
				}
				
			}
		}
		return "failed";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserManagementBean getUserManagementBean() {
		return userManagementBean;
	}

	public void setUserManagementBean(UserManagementBean userManagementBean) {
		this.userManagementBean = userManagementBean;
	}
	
}
