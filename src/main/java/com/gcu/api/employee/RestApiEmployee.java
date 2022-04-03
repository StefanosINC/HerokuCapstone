package com.gcu.api.employee;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.EmployeeService;
import com.gcu.data.EmployeeDataService;
import com.gcu.data.entity.EmployeeEntity;
import com.gcu.model.EmployeeModel;
import com.gcu.repository.EmployeeRepository;

// API Rest Controller
/*
 * 
 * This class is meant to implement all the Rest API's from the employee services.
 */
@RestController
public class RestApiEmployee {

	
	/*
	 * Auto wire the employee service
	 */
	@Autowired 
	EmployeeService employeeservice;
	
	/*
	 * Auto Wire the employee Repository
	 */
	@Autowired 
	EmployeeRepository employeeRepository;
	
	
	@Autowired
	EmployeeDataService dataservice;
	/*
	 * Get Employees API
	 * Call on the List of the Employee Service and Find all 
	 * Verify its not null and return a status 
	 */
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


	
/*
 * Get Employees By ID 
 * Create a EmployeeModel Object and find the specfici employee ID
 */
@GetMapping(path="/getEmployeesID/{id}")
	public ResponseEntity<?> ReturnEmployeeID(@PathVariable("id") String id){
		try {
			EmployeeModel oneEmployee = employeeservice.getEmployeebyID(id);
			
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
 * Create an employee API
 * Reference the INSERT Employee object and pass in the mode.
 */
@PostMapping(path="/createEmployee")

public ResponseEntity<?> CreateEmployee(@RequestBody EmployeeModel employee){
	try {
		EmployeeModel CreateEmployee = employeeservice.insertEmployee(employee);
		
		System.out.println(CreateEmployee.toString());
		
		
		if(CreateEmployee == null ) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else 
				
				return new ResponseEntity<>(CreateEmployee, HttpStatus.OK);		
		
		
	}
	catch(Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
}

/*
 * 
 * Update an Employee API
 * There is a weird error where I have hto set the parameters after the update.
 * Return an updated employee
 */
@PutMapping(path="/updateEmployee/{id}")
public ResponseEntity<EmployeeEntity> edit (@PathVariable("id")String id, @RequestBody EmployeeEntity employee)
{	
	
	employee.setId(id);
	return ResponseEntity.ok().body(this.dataservice.update(employee));
	
}

/*
 * Delete Employee By ID 
 */
@RequestMapping(path="/deleteEmployee/{id}")
public ResponseEntity<?> DeleteByID(@PathVariable("id") String id){
	try {
		
		employeeservice.Delete(id);
			
			if(id == null)
				
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else 
				
				return new ResponseEntity<>(id, HttpStatus.OK);		
		
		
	}
	catch(Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
}

@PostMapping(path="/login")
	public ResponseEntity<?> Login (@RequestBody EmployeeModel user){
	
	System.out.println(user.toString());
	
	try {
		System.out.println("174");
		
		EmployeeModel loginuser = employeeservice.login(user);
		
		System.out.println(loginuser.toString());
		
	if(loginuser == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else 
			
			return new ResponseEntity<>(loginuser, HttpStatus.OK);		
	
	
}
	
	catch(Exception e) {
		e.printStackTrace();
	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

}
	

}
}

