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
 * This is th Time Card Data Service that implements the interface, 
 */
@Service
public class TimeCardDataService implements TimeCardDataAcessInterface<TimeCardEntity>{

	
	@Autowired
	private TimeCardRepository timecardRepository;
	
	public TimeCardDataService(TimeCardRepository timecardRepository) {
		this.timecardRepository = timecardRepository;
	}
	@Override
	public List<TimeCardEntity> FindAllTimePunches() {
		
		List<TimeCardEntity> users = new ArrayList<TimeCardEntity>();
		
		try {
			Iterable<TimeCardEntity> ordersIterable = timecardRepository.findAll();
			users = new ArrayList<TimeCardEntity>();
			ordersIterable.forEach(users::add);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		// return the list
		return users;
		
		
		
	}

	@Override
	public TimeCardEntity findTimeCardById(String id) {
		return timecardRepository.findTimeCardById(id);
	}

	
	// to translate the punchand punch out to strings  away from dates
	@Override
	public TimeCardEntity Punch_In(TimeCard card) {
	
		
		
		SimpleDateFormat testFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		testFormat.setTimeZone(TimeZone.getTimeZone("US/Arizona"));
		System.out.println(testFormat.toString());
		
		
		
		
		
		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm;ss");
		String test = time.format(formatter);
		System.out.println(test.toString() + "  Yo this is the time");
		System.out.println("Below is the example punch in");
		System.out.println(test.toString());
		
		
		
		/*
		 * This is the regular input
		 */
		TimeCardEntity Punch_In = null;
		

		Punch_In = new TimeCardEntity(card.getId(), card.getFirstname(), card.getLastname(), card.getPunch_in(), card.getPunch_out(), card.getComments(), card.getRole());
		

		Punch_In = this.timecardRepository.save(Punch_In);
		
		
		
		System.out.println(Punch_In.toString());
		
		return Punch_In;
	}

	@Override
	public TimeCardEntity Punch_Out(TimeCard card) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TimeCardEntity UpdateTimeCard(TimeCard punch_in) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void DeleteTimePunchById(String id) {
		// TODO Auto-generated method stub
		timecardRepository.deleteById(id);
		
	}

}
