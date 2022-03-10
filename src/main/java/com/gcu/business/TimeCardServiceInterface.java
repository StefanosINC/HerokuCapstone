package com.gcu.business;

import java.util.List;

import com.gcu.model.TimeCard;

public interface TimeCardServiceInterface {

	
	public void init();
	
	public void destroy();
	
	
	public TimeCard Punch_In(TimeCard card);
	
List<TimeCard>FindAllTimePunches();

public TimeCard getTimeCardID(String id);


public void Delete(String id);

}
