package com.gcu.model;

import java.util.List;

public class EmployeeModel {

	private String employee_id;
	
	private String username;
	private String password;
	private String email;
	private String phone;
	private String firstname;
	private String lastname;
	private String role;
	
	
	// has a relationship
	private List<TimeCard> timecard;
	
	
	
	
	public EmployeeModel(String employee_id, String username, String password, String email, String phone,
			String firstname, String lastname, String role, List<TimeCard> timecard) {
		super();
		this.employee_id = employee_id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.firstname = firstname;
		this.lastname = lastname;
		this.role = role;
	}


	public EmployeeModel() {
		
	}
	

	public List<TimeCard> getTimecard() {
		return timecard;
	}


	public void setTimecard(List<TimeCard> timecard) {
		this.timecard = timecard;
	}


	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
