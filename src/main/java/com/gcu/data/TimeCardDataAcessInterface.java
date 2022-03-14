package com.gcu.data;

import java.util.List;

import com.gcu.data.entity.TimeCardEntity;

import com.gcu.model.TimeCard;

/*
 * Interface for the TimeCardDataService.
 * This class implements the methods that will be used in the datacess service. 
 * This manages the CRUD operations for the timecard. 
 */
public interface TimeCardDataAcessInterface <T>{

	public List<TimeCardEntity> FindAllTimePunches();
	
	public TimeCardEntity findTimeCardById(String id) ;
	
	public TimeCardEntity PunchIn(TimeCard card);
	
	
	public TimeCardEntity UpdateTimeCard(TimeCard card);
	
	public void DeleteTimePunchById(String id);
	
	
}
