package com.gcu.api.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.EmployeeService;
import com.gcu.data.EmployeeDataService;
import com.gcu.model.EmployeeModel;

@RestController
@RequestMapping("/service")
public class RestApiEmployee {

	
	
	@Autowired
	EmployeeDataService dataservice;
	
	
	@Autowired 
	EmployeeService employeeservice;
	
	
	
	@GetMapping(path="/getEmployees")
		public ResponseEntity<?> getEmployees(){
			try {
				List<EmployeeModel> employees = employeeservice.findAll();
				if(employees == null ) 
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
					else 
						
						return new ResponseEntity<>(employees, HttpStatus.OK);		
				
				
			}
			catch(Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
			}
	}




@GetMapping(path="/getEmployeesID/{id}")
	public ResponseEntity<?> ReturnEmployeeID(@PathVariable("id") String id){
		try {
			EmployeeModel oneEmployee = employeeservice.getEmployeebyID(id);
			if(oneEmployee == null ) 
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				else 
					
					return new ResponseEntity<>(oneEmployee, HttpStatus.OK);		
			
			
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
}

}

