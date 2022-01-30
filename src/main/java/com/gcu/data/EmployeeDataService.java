package com.gcu.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.gcu.data.entity.EmployeeEntity;
import com.gcu.model.EmployeeModel;

import com.gcu.repository.EmployeeRepository;

@Service
public class EmployeeDataService implements EmployeeDataAccessInterface<EmployeeEntity>{

	
	// Auto Wire Repository
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeDataService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}


	
	// Find and All. (Print the entire list of Register users)
	
	@Override
	public List<EmployeeEntity> findAll() 
	{
		List<EmployeeEntity> users = new ArrayList<EmployeeEntity>();
		
		try {
			Iterable<EmployeeEntity> ordersIterable = employeeRepository.findAll();
			users = new ArrayList<EmployeeEntity>();
			ordersIterable.forEach(users::add);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		// return the list
		return users;
		
	}
	
	@Override
	public boolean login(EmployeeModel user) 
	{
		int count = 0;
		List<EmployeeEntity> users = new ArrayList<EmployeeEntity>();
		
		users = findAll();
		
		for(int i = 0; i <users.size(); i++) {
	
			if(users.get(i).getUsername().equals(user.getUsername()) && users.get(i).getPassword().equals(user.getPassword())); {
				System.out.println(users.get(i).getUsername() + " Is Apparantly Equal To " + user.getUsername());
				count++;
				
			}
			
		}
		if(count == 1)
			
			
			return true;
		
		System.out.println(count);
		System.out.print(user.getUsername());
		System.out.print(user.getPassword());
		
		return false;
	}

	@Override
	public List<EmployeeEntity> FindAllEmployees() {
		
		List<EmployeeEntity> employees = new ArrayList<EmployeeEntity>();
		try {
			Iterable<EmployeeEntity> employeesIterable = employeeRepository.findAll();
			employees = new ArrayList<EmployeeEntity>();
			employeesIterable.forEach(employees:: add);
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return employees;
	}


@Override
public EmployeeEntity findByUsername(String username) 
{		
	return employeeRepository.findByUsername(username);
}



@Override
public EmployeeEntity create(EmployeeModel t) {
	// TODO Auto-generated method stub
	EmployeeEntity newEmployee = null;

	newEmployee = new EmployeeEntity(t.getEmployee_id(), t.getUsername(), t.getPassword(), t.getEmail(), t.getPhone(), t.getFirstname(), t.getLastname(), t.getRole());			
	 
	newEmployee = this.employeeRepository.save(newEmployee);
	
	
	
	return newEmployee;
}







@Override
public EmployeeEntity update(EmployeeModel t) {
	// Make a new album entity
			EmployeeEntity employeeEntity = new EmployeeEntity(t.getEmployee_id(), t.getUsername(), t.getPassword(), t.getEmail(), t.getPhone(), t.getFirstname(), t.getLastname(), t.getRole());	
			// Making a new album entity, saving the album entity, then return it at the end of the method.
			employeeEntity = this.employeeRepository.save(employeeEntity);
			
			

			return employeeEntity;
		}



@Override
public EmployeeEntity findById(String id) {
	return employeeRepository.getOrderById(id);
	
	
	
}



@Override
public void DeleteUser(String t){
	// TODO Auto-generated method stub

	employeeRepository.deleteById(t);
	Optional<EmployeeEntity> user;
	user = employeeRepository.findById(t);
	
	
	
	
}


}



