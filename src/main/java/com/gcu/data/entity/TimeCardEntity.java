package com.gcu.data.entity;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * TimeCard Entity Class, This Class implements the Entity class that will communicate to the Database
 * @Param - @Document Collection= Timecard. This class will talk directly to the timecard document
 * 
 */
@Document(collection="timecard")
public class TimeCardEntity {

	/*
	 * Entity Parameters
	 */
	
	@Id
	String id;
	
	@Indexed(unique=true)
	String firstname;
	String lastname;
	String punch_in;
	String punch_out;
	String comments;
	String role;
	

	
	
	
	/*
	 * Default Constructor
	 */
	public TimeCardEntity() {
		
	}


	/*
	 * Constructor for the TimeCard Entity
	 */
	public TimeCardEntity(String id, String firstname, String lastname, String punch_in, String punch_out,
			String comments, String role) {
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
 * Getters and Setters
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
		return "TimeCardEntity [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", punch_in="
				+ punch_in + ", punch_out=" + punch_out + ", comments=" + comments + ", role=" + role + "]";
	}


	
}
