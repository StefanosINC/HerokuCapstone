package com.gcu.business;

import java.util.List;

import com.gcu.model.TimeCard;

/*
 * This is the TimeciardService interface Class. 
 * This will inherit the Entity propertie sand convert them into models. 
 * This is part of the entity frameworks and is also inheriting the spring beans. 
 * 
 */
public interface TimeCardServiceInterface {

	
	public void init();

	public void destroy();
	
	
	public TimeCard PunchIn(TimeCard card);
	
	List<TimeCard>FindAllTimePunches();

	public TimeCard getTimeCardID(String id);
	

	public void Delete(String id);

}
