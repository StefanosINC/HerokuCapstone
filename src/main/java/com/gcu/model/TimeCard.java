package com.gcu.model;

import java.util.Date;

public class TimeCard {

	
	private String id;
	private Date punch_in;
	private Date punch_out;
	private String comments;
	
	
	
	public TimeCard(String id, Date punch_in, Date punch_out, String comments) {
		super();
		this.id = id;
		this.punch_in = punch_in;
		this.punch_out = punch_out;
		this.comments = comments;
		
		
		
		
		
		
	}
	public TimeCard() {
		
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
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
	
	
	
}
