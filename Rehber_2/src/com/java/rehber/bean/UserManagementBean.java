package com.java.rehber.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.event.SelectEvent;

import com.java.rehber.bean.User.Roles;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserManagementBean implements Serializable {

	private static List<User> initialUserList = new ArrayList<User>();
	private static List<String> roles = new ArrayList<>();

	@ManagedProperty(value="#{appBean}")
	private ApplicationPropertiesBean propertiesBean;

	static {
		for (int i = 0; i < 100; i++) {
			UserManagementBean.initialUserList.add(User.getRandomUser());
		}

		Roles[] values = User.Roles.values();
		for (Roles role : values) {
			roles.add(role.name());
		}

		User user = new User();
		user.setUuid(UUID.randomUUID().toString());
		user.setName("osman");
		user.setEmail("osman2@osman2.com");
		user.setPhone("05435022314");
		user.setRole(Roles.ADMIN);
		user.setSurname("Yaycioglu");
		user.setUsername("osman");
		user.setPassword("osman");
		UserManagementBean.initialUserList.add(user);
	}

	private static final long serialVersionUID = -1662311877237839875L;
	private List<User> userList = new ArrayList<User>();
	private List<User> selectedUserList;
	private User user = new User();
	private String actionName;

	public void addUpdateUser() {
		if ("add".equals(this.actionName)) {
			this.user.setUuid(UUID.randomUUID().toString());
			this.userList.add(this.user);

		} else if ("update".equals(this.actionName)) {
			for (User userC : this.userList) {
				if (userC.getUuid().equals(this.user.getUuid())) {
					userC.setCity(this.user.getCity());
					userC.setEmail(this.user.getEmail());
					userC.setExtra(this.user.getExtra());
					userC.setName(this.user.getName());
					userC.setPassword(this.user.getPassword());
					userC.setPhone(this.user.getPhone());
					userC.setRole(this.user.getRole());
					userC.setSurname(this.user.getSurname());
					userC.setUsername(this.user.getUsername());
				}
			}
		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null,
				new FacesMessage("User  : " + this.user.getName()
						+ " successfully added."));
		this.user = new User();
	}

	public void action(final String actionStr) {
		this.actionName = actionStr;
		if ("add".equals(actionStr)) {
			this.user = new User();
		} else if ("update".equals(actionStr)) {
		}

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("action set to : "
				+ actionStr));
		
	}

	public List<User> getUserList() {
		return this.userList;
	}

	public void setUserList(final List<User> userList) {
		this.userList = userList;
	}

	@PostConstruct
	public void functionCons() {
		this.userList.addAll(UserManagementBean.initialUserList);
		System.out.println(getPropertiesBean().getAppName());
	}

	@PreDestroy
	public void functionDest() {
		this.userList.clear();
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(final User user) {
		this.user = user;
	}

	public String getActionName() {
		return this.actionName;
	}

	public void setActionName(final String actionName) {
		this.actionName = actionName;
	}

	public void check() {
		System.out.println("buradayim");
	}

	public City[] getCities() {
		return City.cities;
	}

	public List<User> getSelectedUserList() {
		return this.selectedUserList;
	}

	public void setSelectedUserList(final List<User> selectedUserList) {
		this.selectedUserList = selectedUserList;
	}

	public void onRowSelect(final SelectEvent selectEvent) {
		User userObject = (User) selectEvent.getObject();
		this.user = userObject;

	}

	public void deleteUser() {
		int indexOf = this.userList.indexOf(this.user);
		this.userList.remove(indexOf);
	}

	public void deleteUsers() {
		if ((this.selectedUserList != null)
				&& (this.selectedUserList.size() > 0)) {
			this.userList.removeAll(this.selectedUserList);
		}
	}

	public Roles[] getRoles() {
		EnumSet<Roles> roles = EnumSet.allOf(Roles.class);
		return roles.toArray(new Roles[roles.size()]);
	}

	public ApplicationPropertiesBean getPropertiesBean() {
		return propertiesBean;
	}

	public void setPropertiesBean(ApplicationPropertiesBean propertiesBean) {
		this.propertiesBean = propertiesBean;
	}
	public void handleValueChange(ValueChangeEvent changeEvent){
		System.out.println("I am here Bean handleValueChange");
	}
	public void selectAjax(){
		System.out.println("I am here Bean selectAjax");
	}
	public void listenAction(ActionEvent listener){
		System.out.println("I am here  listenAction");
		FacesContext.getCurrentInstance().renderResponse();
	}
}
