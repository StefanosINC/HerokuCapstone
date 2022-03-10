package com.gcu.data;

import java.util.List;

import com.gcu.data.entity.TimeCardEntity;
import com.gcu.model.TimeCard;

/*
 * Interface for the TimeCardDataService.
 */
public interface TimeCardDataAcessInterface <T>{

	public List<TimeCardEntity> FindAllTimePunches();
	
	public TimeCardEntity findTimeCardById(String id);
	
	public TimeCardEntity Punch_In(TimeCard card);
	
	public TimeCardEntity Punch_Out(TimeCard card);
	
	public TimeCardEntity UpdateTimeCard(TimeCard punch_in);
	
	public void DeleteTimePunchById(String id);
	
	
	
}
