package com.java.rehber.bean;

import java.util.EnumSet;
import java.util.Random;
import java.util.UUID;

public class User {

	public enum Roles {
		ADMIN, USER, REPORT;
	}

	private String uuid;
	private String name;
	private String surname;
	private String username;
	private String password;
	private String phone;
	private String email;
	private String extra;
	private Integer city;
	private Roles role = Roles.USER;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Roles getRole() {
		return role;
	}

	public Roles[] getRoles() {
		EnumSet<Roles> roles = EnumSet.allOf(Roles.class);
		return roles.toArray(new Roles[roles.size()]);
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public static User getRandomUser() {
		Random random = new Random();
		User user = new User();
		user.setUuid(UUID.randomUUID().toString());
		user.setName("osman" + random.nextInt());
		user.setEmail("" + random.nextInt() + "@osman.com");
		user.setPhone("054350" + random.nextInt());
		user.setRole(Roles.USER);
		user.setSurname("Yaycioglu" + random.nextInt());
		user.setUsername("os" + random.nextInt());
		return user;

	}

}
