package com.qa.todo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private String username;
	private String hashPassword;
	private String authToken;
	
	public User () {
		
	}
	
	public User (String username, String hashPassword) {
		this.username = username;
		this.hashPassword = hashPassword;
	}

	public User(String username, String hashPassword, String authToken) {
		super();
		this.username = username;
		this.hashPassword = hashPassword;
		this.authToken = authToken;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getHashPassword() {
		return hashPassword;
	}

	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}

	public String getAuth() {
		return authToken;
	}

	public void setAuth(String authToken) {
		this.authToken = authToken;
	}
	
	
}
