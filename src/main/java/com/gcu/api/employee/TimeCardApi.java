package com.gcu.api.employee;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@Autowired
	TimeCardService service;
	

    @PostMapping(path="/Punch")
	public ResponseEntity<?> CreateTimePunch(TimeCard card){

    	
	try {
	
		
	
		
			TimeCard Insert = service.Punch_In(card);
			
			System.out.println(Insert);
			
			System.out.println(card.toString() + " test");
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
	
}




// Get Employees By ID 
@GetMapping(path="/getCard")
	public ResponseEntity<?> getTimeCard(){
		try {
			
			
			List<TimeCard> employees = service.FindAllTimePunches();
			if(employees == null ) 
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				else 
					
					return new ResponseEntity<>(employees, HttpStatus.OK);		
			
			
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
}

//Find By ID
@GetMapping(path="/getTimeCard/{id}")
	public ResponseEntity<?> ReturnEmployeeID(@PathVariable("id") String id){
		try {
			TimeCard oneEmployee = service.getTimeCardID(id);
			
			System.out.println(id);
			if(oneEmployee == null ) 
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				else 
					
					return new ResponseEntity<>(oneEmployee, HttpStatus.OK);		
			
			
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
}

//Delete API
@RequestMapping(path="/DeleteTimeCardID/{id}")
public ResponseEntity<?> DeleteByID(@PathVariable("id") String id){
	try {
		
			service.Delete(id);
			
			if(id == null)
				
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else 
				
				return new ResponseEntity<>(id, HttpStatus.OK);		
		
		
	}
	catch(Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
}

}
