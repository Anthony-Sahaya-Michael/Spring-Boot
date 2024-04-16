package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class EmployeeCredentials {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int credId;
	private String username;
	private String password;
	
	public EmployeeCredentials() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeCredentials(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
}
