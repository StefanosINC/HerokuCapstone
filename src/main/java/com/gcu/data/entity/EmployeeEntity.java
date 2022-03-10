package com.gcu.data.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.gcu.model.TimeCard;

/*
 * Employee Entity Class, This Class implements the Entity class that will communicate to the Database
 * @Param - @Document Collection=employees. This class will talk directly to the employees document
 * 
 */

@Document(collection="employees")
public class EmployeeEntity {

	/*
	 * Parameters for the Employee Entity 
	 */
	@Id
	String id;
	
	@Indexed(unique=true)
	String username;
	
	String password;
	
	String email;
	
	String phone;
	
	String firstname;
	
	String lastname;
	
	String role;

	/*
	 * Default Constructor
	 */
	
	public EmployeeEntity() {
		
	}
	
	/*
	 * Constructor for Employee Entity
	 */

	public EmployeeEntity(String id, String username, String password, String email, String phone, String firstname,
			String lastname, String role){
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.firstname = firstname;
		this.lastname = lastname;
		this.role = role;
	}







/*
 * 
 * Getters and Setters
 */

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
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
