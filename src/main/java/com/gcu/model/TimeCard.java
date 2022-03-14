package com.gcu.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;


/*
 * This is the TimeCard Model Class
 */
public class TimeCard {

	/*
	 * Parameters for the class.
	 */
	private String id;
	private String firstname;
	private String lastname;
	private String punch_in;
	private String punch_out;
	private String comments;
	private String role;
	
	
/*
 * Constructor for the TimeCard
 */
	public TimeCard(String id, String firstname, String lastname, String punch_in, String punch_out, String comments,
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


/*
 * Default Constructor
 */
	public TimeCard() {
		
	}


/*
 * 
 * Getters and Setters for the TimeCard Class
 */
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

	public String getPunch_in() {
		return punch_in;
	}


	public void setPunch_in(String punch_in) {
		this.punch_in = punch_in;
	}


	public String getPunch_out() {
		return punch_out;
	}


	public void setPunch_out(String punch_out) {
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



	@Override
	public String toString() {
		return "TimeCard [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", punch_in=" + punch_in
				+ ", punch_out=" + punch_out + ", comments=" + comments + ", role=" + role + "]";
	}



	



	
}
