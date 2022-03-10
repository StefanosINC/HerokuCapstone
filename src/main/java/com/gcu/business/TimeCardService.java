package com.gcu.business;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.TimeCardDataService;
import com.gcu.data.entity.EmployeeEntity;
import com.gcu.data.entity.TimeCardEntity;
import com.gcu.model.EmployeeModel;
import com.gcu.model.TimeCard;

@Service
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
	public List<TimeCard> FindAllTimePunches() {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		// Get all the Entity Albums using the findAll() method from the AlbumDataService class.
		List<TimeCardEntity> userEntity = dataservice.FindAllTimePunches();
		
		// Iterate over the Entity Albums and create a list of Domain Albums
		List<TimeCard> userdomain = new ArrayList<TimeCard>();
		for(TimeCardEntity entity : userEntity)
		{
			userdomain.add(new TimeCard(entity.getId(), entity.getFirstname(), entity.getLastname(), entity.getPunch_in(),entity.getPunch_out(),entity.getComments(),entity.getRole()));
			
			
		}
		
		return userdomain;	
	
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

	@Override
	public TimeCard getTimeCardID(String id) {
		TimeCardEntity Punch_In = dataservice.findTimeCardById(id);
		return new TimeCard(Punch_In.getId(), Punch_In.getFirstname(), Punch_In.getLastname(),  Punch_In.getPunch_in(), Punch_In.getPunch_out(),Punch_In.getComments(), Punch_In.getRole());
	}

	@Override
	public void Delete(String id) {
		// TODO Auto-generated method stub
		dataservice.DeleteTimePunchById(id);
	}
}
