package com.gcu.api.employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gcu.business.TimeCardService;
import com.gcu.model.TimeCard;

/*
 * Rest Controller for the Timecard APIs
 * 
 */
@RestController
@RequestMapping("/service1")
public class TimeCardApi {



	/*
	 * Autowire the TimeCard Service
	 */
	@Autowired
	TimeCardService service;
	
	/*
	 * Create a Time Punch. 
	 * @Param - TimeCard - card 
	 * @return TimeCard Object
	 * Create a TimeCard object and refer it to the TimeCard Service.
	 * Loop the logic in a try catch and verify the status of the HTTP request and its current state. 
	 */
    @PostMapping(path="/Punch")
	public ResponseEntity<?> CreateTimePunch(TimeCard card){


	try {

			TimeCard Insert = service.PunchIn(card);
		
			if(Insert == null ) 
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				else 
					
					return new ResponseEntity<>(Insert, HttpStatus.OK);		
			
			
		}
		catch(Exception e) {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
}

/*
 * This returns the Card Object
 * Create a list of Employees and Find all the Time Punches
 * If there is a null value, return not found if not return the ok
 */
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

/*
 * Return the TimeCard Object by the ID
 * Return the TimeCard object researched
 */
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

/*
 * Delete the specific TimeCard Object by the ID 
 * 
 */
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
