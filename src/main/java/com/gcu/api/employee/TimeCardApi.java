package com.gcu.api.employee;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.EmployeeService;
import com.gcu.business.TimeCardService;
import com.gcu.data.EmployeeDataService;
import com.gcu.data.TimeCardDataService;
import com.gcu.model.EmployeeModel;
import com.gcu.model.TimeCard;

import groovyjarjarantlr.debug.Event;
@RestController
@RequestMapping("/service1")
public class TimeCardApi {


	@Autowired
	TimeCardDataService dataservice;
	
	TimeCardService service;
	

    @PostMapping(path="/Punch")//(value = "punch_in",method = RequestMethod.POST)
	public ResponseEntity<?> CreateTimePunch(TimeCard card){

    	
	try {
		LocalDateTime time = LocalDateTime.now();
		
		card.setPunch_in(time);
		card.setPunch_out(time);
		
	
		
			TimeCard Insert = service.Punch_In(card);
			
			
		
			if(Insert == null ) 
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				else 
					
					return new ResponseEntity<>(Insert, HttpStatus.OK);		
			
			
		}
		catch(Exception e) {
			
		//	System.out.println(card.getPunch_in().toString());
		//	System.out.println(card.getPunch_out().toString());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		
		}
}
@PostMapping("/date")
public void date(@RequestParam("date") 
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
    // ...
}
}
