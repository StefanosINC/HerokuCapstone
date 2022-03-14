package com.gcu.api.employee;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.EmployeeService;
import com.gcu.data.EmployeeDataService;
import com.gcu.model.EmployeeModel;
import com.gcu.repository.EmployeeRepository;

@RestController
public class RestApiEmployee {

	
	@Autowired 
	EmployeeService employeeservice;
	
	
	@Autowired 
	EmployeeRepository employeeRepository;
	
	
	// Get Employees By ID 
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


	
// Find By ID
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

// Find by Role 
@PostMapping(path="/createEmployee")
public ResponseEntity<?> CreateEmployee(EmployeeModel employee){
	try {
		EmployeeModel CreateEmployee = employeeservice.insertEmployee(employee);
		
		System.out.println(CreateEmployee);
		
		if(CreateEmployee == null ) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else 
				
				return new ResponseEntity<>(CreateEmployee, HttpStatus.OK);		
		
		
	}
	catch(Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
}

// @PathVariable("id") String id,
@PostMapping(path="/updateEmployee")
public ResponseEntity<?> edit ( EmployeeModel employee)
{
	//EmployeeModel EmployeeID = employeeservice.getEmployeebyID(id);
	 
	EmployeeModel updatedEmployee = employeeservice.update(employee);
	
	updatedEmployee.setEmployee_id(employee.getEmployee_id());
	updatedEmployee.setUsername(employee.getUsername());
	updatedEmployee.setPassword(employee.getPassword());
	updatedEmployee.setFirstname(employee.getFirstname());
	updatedEmployee.setLastname(employee.getLastname());
	updatedEmployee.setPhone(employee.getPhone());
	updatedEmployee.setRole(employee.getRole());

	
	try {
		
		if(updatedEmployee == null ) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else 
				
				return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);		
		
		
	}
	catch(Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
	
}

// Delete API
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










}

