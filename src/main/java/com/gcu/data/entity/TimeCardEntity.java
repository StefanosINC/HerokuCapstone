package com.gcu.data.entity;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.gcu.model.TimeCard;

@Document(collection="timecard")
public class TimeCardEntity {

	@Id
	String id;
	@Indexed(unique=true)
	String firstname;
	String lastname;
	
	private Date punch_in = Date.from(Instant.now());
	
	private Date punch_out = Date.from(Instant.now());
	private String comments;
	String role;
	

	
	public TimeCardEntity() {
		
	}








	public TimeCardEntity(String id, String firstname, String lastname, Date punch_in, Date punch_out, String comments,
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








	public TimeCardEntity(String id, String firstname, String lastname, String comments, String role) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.comments = comments;
		this.role = role;
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
