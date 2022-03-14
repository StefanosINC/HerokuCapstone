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

/*
 * 
 * This is the TimeCardService that implements the TimeCardServiceInterface
 * This will autowire the dataservice and inherit similar methods from the dataaccess interface for the TimeCard
 */
@Service
public class TimeCardService implements TimeCardServiceInterface{

	/*
	 * Autowire the TimeCardDataService to call on the dataservice methods.
	 */
	@Autowired 
	TimeCardDataService dataservice;
	
	/*
	 * Spring bean Init
	 */
	@Override
	public void init() {
	
	}

	/*
	 * Spring bean destroy
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/* Loop through the Timecard and Find all the Time Punches. 
	 * Refer the FindAllTimePunches from the dataservice
	 * Create a new list and then add the entitys to the domain object.
	 * Return the object that has all the time punches
	 * 
	 */
	@Override
	public List<TimeCard> FindAllTimePunches() {
		
		List<TimeCardEntity> userEntity = dataservice.FindAllTimePunches();
		
	
		List<TimeCard> userdomain = new ArrayList<TimeCard>();
		for(TimeCardEntity entity : userEntity)
		{
			userdomain.add(new TimeCard(entity.getId(), entity.getFirstname(), entity.getLastname(), entity.getPunch_in(),entity.getPunch_out(),entity.getComments(),entity.getRole()));
			
			
		}
		
		return userdomain;	
	
	}

	/*
	 * Create a Time Punch.
	 * Create a Time Punch Entity and and refer to the dataservice.punchin.
	 * Once you refer the data service return the TimeCard object
	 * 
	 */
	@Override
	public TimeCard PunchIn(TimeCard card) {
	
		TimeCardEntity Punch_In = dataservice.PunchIn(card);
		
		return new TimeCard(Punch_In.getId(), Punch_In.getFirstname(), Punch_In.getLastname(),  Punch_In.getPunch_in(), Punch_In.getPunch_out(),Punch_In.getComments(), Punch_In.getRole());
	}


	/*
	 * Set the TimeCard PunchIn Object = to the datasevice and find the timecard by the ID
	 * Return the TimeCard Object
	 */
	@Override
	public TimeCard getTimeCardID(String id) {
		TimeCardEntity Punch_In = dataservice.findTimeCardById(id);
		return new TimeCard(Punch_In.getId(), Punch_In.getFirstname(), Punch_In.getLastname(),  Punch_In.getPunch_in(), Punch_In.getPunch_out(),Punch_In.getComments(), Punch_In.getRole());
	}

	/*
	 * Call on the datasevice and delete the time punch by the ID
	 */
	@Override
	public void Delete(String id) {
		// TODO Auto-generated method stub
		dataservice.DeleteTimePunchById(id);
	}
}
