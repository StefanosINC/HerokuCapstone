package com.gcu.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;


public class TimeCard {

	
	private String id;
	private String firstname;
	private String lastname;
	
	
	
	private Date punch_in = Date.from(Instant.now());
	private Date punch_out = Date.from(Instant.now());
	
	private String comments;
	private String role;
	




	public TimeCard(String id, String firstname, String lastname, Date punch_in, Date punch_out, String comments,
			String role) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.punch_in = punch_in;
		this.punch_out = punch_out;
		this.comments = comments;
		this.role = role;
	}



	public TimeCard(String id, String firstname, String lastname, String comments, String role) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.comments = comments;
		this.role = role;
	}



	public TimeCard() {
		
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
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



	public Date getPunch_in() {
		return punch_in;
	}



	public void setPunch_in(Date punch_in) {
		this.punch_in = punch_in;
	}



	public Date getPunch_out() {
		return punch_out;
	}



	public void setPunch_out(Date punch_out) {
		this.punch_out = punch_out;
	}



	public String getComments() {
		return comments;
	}



	public void setComments(String comments) {
		this.comments = comments;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	



	
}
