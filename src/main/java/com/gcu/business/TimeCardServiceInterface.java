package com.gcu.business;

import com.gcu.model.TimeCard;

public interface TimeCardServiceInterface {

	
	public void init();
	
	public void destroy();
	
	public TimeCard FindAllTimePunches();
	
	public TimeCard Punch_In(TimeCard card);
}
