package com.gcu.data;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.EmployeeEntity;
import com.gcu.data.entity.TimeCardEntity;
import com.gcu.model.TimeCard;
import com.gcu.repository.TimeCardRepository;



/*
 * This class implements the TimeCardDataAccess Interface and is the connection to the Database
 * This class implements the actual logic as well and is responsible for importing the repository from the TimeCard
 * This class is a service class and is the main driver of functionality in the program for the TimeCard.
 */
@Service
public class TimeCardDataService implements TimeCardDataAcessInterface<TimeCardEntity>{

	
	/*
	 * TimeCard Repository
	 * @Param - Autowired TimeCard
	 * Implments the TimeCard repository instance.
	 */
	@Autowired
	private TimeCardRepository timecardRepository;
	
	/*
	 * Constructor for the time card repository data service
	 * 
	 */
	public TimeCardDataService(TimeCardRepository timecardRepository) {
		this.timecardRepository = timecardRepository;
	}
	
	/*
	 * Find all time punches. This Method loops thorugh the TimeCardEntity and creates a TimeCard List object
	 * Loop through the TimeCard and loop it through the timecard repository and find all. 
	 * Add each of the parameteres to the list and return it 
	 * 
	 */
	@Override
	public List<TimeCardEntity> FindAllTimePunches() {
		
		List<TimeCardEntity> timecard = new ArrayList<TimeCardEntity>();
		
		try {
			Iterable<TimeCardEntity> ordersIterable = timecardRepository.findAll();
			timecard = new ArrayList<TimeCardEntity>();
			ordersIterable.forEach(timecard::add);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		// return the list
		return timecard;
		
		
		
	}

	
	/*
	 * Find the timecard by ID
	 * Refer the actual findtimecard repository from the mongo repository
	 * Return it.
	 */
	@Override
	public TimeCardEntity findTimeCardById(String id) {
		return timecardRepository.findTimeCardById(id);
	}

	
	/*
	 * Create a Punch IN for the timecard
	 * Set the TimeCard objec to null, 
	 * Set the object to == a new TimeCard Card object.
	 * Then Save the punch in to the mongodb by refering to the save repository.
	 * return the punch in
	 */
	@Override
	public TimeCardEntity PunchIn(TimeCard card) {
		
		TimeCardEntity Punch_In = null;
		
		Punch_In = new TimeCardEntity(card.getId(), card.getFirstname(), card.getLastname(), 
				card.getPunch_in(), card.getPunch_out(), card.getComments(), card.getRole());
	
		Punch_In = this.timecardRepository.save(Punch_In);
		
		
		return Punch_In;
		
	}

	

	
	/*
	 * Update a Time Card Object
	 * Create a New TimeCard object and create set it equal to a new TimeCard object
	 * Save this TimeCard Object.
	 * The key difference here is that we are not setting it to null first
	 */
	@Override
	public TimeCardEntity UpdateTimeCard(TimeCardEntity t) {
		
//		TimeCardEntity updateTimeCard = new TimeCardEntity(card.getId(), card.getFirstname(), card.getLastname(), 
//				card.getPunch_in(), card.getPunch_out(), card.getComments(), card.getRole());
//		
//				updateTimeCard = this.timecardRepository.save(updateTimeCard);
//				
//				return updateTimeCard;
//	}


Optional <TimeCardEntity> employeeDB = this.timecardRepository.findById(t.getId());
if(employeeDB.isPresent()) {
	TimeCardEntity Card = employeeDB.get();
	Card.setId(t.getId());
	Card.setFirstname(t.getFirstname());
	
	Card.setLastname(t.getLastname());
	
	Card.setPunch_in(t.getPunch_in());
	
	Card.setPunch_out(t.getPunch_out());

	Card.setComments(t.getComments());
	Card.setRole(t.getRole());

	System.out.println("Here");
	timecardRepository.save(Card);
	System.out.println("Save");
	System.out.println(Card.toString());
	return Card;
	
}else {
		
	  throw new ResourceNotFoundException("Record not found with id : " + t.getId());
}
	
	
	
}
	
	
	/*
	 * DeleteByPunchID
	 * Look into the timecard repository and refer to the object by the ID and delete it by ID
	 */
	@Override
	public void DeleteTimePunchById(String id) {
		// TODO Auto-generated method stub
		timecardRepository.deleteById(id);
		
	}

}
