package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.TimeCardDataService;
import com.gcu.data.entity.TimeCardEntity;
import com.gcu.model.TimeCard;

public class TimeCardService implements TimeCardServiceInterface{

	@Autowired 
	TimeCardDataService dataservice;
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TimeCard FindAllTimePunches() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TimeCard Punch_In(TimeCard card) {
		// TODO Auto-generated method stub
		TimeCardEntity Punch_In = dataservice.Punch_In(card);
		
		return new TimeCard(Punch_In.getId(), Punch_In.getFirstname(), Punch_In.getLastname(),  Punch_In.getPunch_in(), Punch_In.getPunch_out(),Punch_In.getComments(), Punch_In.getRole());
	}

	public void test(String date) {
	
		TimeCard test = new TimeCard();
		
		
		
	}
}
