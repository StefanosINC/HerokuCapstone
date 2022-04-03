package com.gcu.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.gcu.data.entity.EmployeeEntity;

import com.gcu.model.EmployeeModel;

import com.gcu.repository.EmployeeRepository;


/*
 * EmployeeData Service that Implements the EmployeeDataAccessInterface Entity
 * This class is directly responsible for creating the logic that connects to the database.
 * This is responsible for the CRUD operations and Login.
 */
@Service
public class EmployeeDataService implements EmployeeDataAccessInterface<EmployeeEntity>{

	
	/*
	 * This is the employee repository instance and is autowired to refer  it to gain acess to its referred methods
	 */
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	/*
	 * This is the EmployeeDataService constructor.
	 */
	public EmployeeDataService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}


	
	/*
	 * Find all Employees This Method loops thorugh the EmployeeEntity and creates a users List object
	 * Loop through the EmployeeList and loop it through the Employee repository and find all. 
	 * Add each of the parameteres to the list and return it 
	 */
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
	
	/*
	 * 
	 * This is responsible for the login for a user. This method loops through the employee entity and finds all the users.
	 * It then compares the returned users from the entity list to the model that was inserted and validates the login
	 */
	@Override
	public EmployeeEntity login(EmployeeModel user) 
	{
	 EmployeeEntity LoginEmployee = employeeRepository.findByUsername(user.getUsername());
		
	 System.out.println(" Data Service " + LoginEmployee.toString());
	 
	 if(!LoginEmployee.getPassword().equals(user.getPassword()))
	 
	 return null;
	 else
		 return LoginEmployee;
	 }
	

	 /* Create a Employee for the EmployeeEntity
	 * Set the newEmployee object to null, 
	 * Set the object to equal a new EmployeeEntity Card object.
	 * Then Save the Object in to the mongodb by refering to the save repository
	 *return the punch in
	 */
	
@Override
public EmployeeEntity create(EmployeeModel t) {
	// TODO Auto-generated method stub
	EmployeeEntity newEmployee = null;

	newEmployee = new EmployeeEntity(t.getEmployee_id(), t.getUsername(), t.getPassword(), t.getEmail(), t.getPhone(), t.getFirstname(), t.getLastname(), t.getRole());			
	 
	newEmployee = this.employeeRepository.save(newEmployee);
	
	
	
	return newEmployee;
}






/*
 * Update a Employee Object Object
 * Create a employee object and create set it equal to a new Employee object
 * Save this Employee Object.
 * The key difference here is that we are not setting it to null first
 */
@Override
public EmployeeEntity update(EmployeeEntity t) {
	// Make a new album entity
//EmployeeEntity employeeEntity = new EmployeeEntity(t.getEmployee_id(), t.getUsername(), t.getPassword(), t.getEmail(), t.getPhone(), t.getFirstname(), t.getLastname(), t.getRole());	
//			// Making a new album entity, saving the album entity, then return it at the end of the method.
//employeeEntity = this.employeeRepository.save(employeeEntity);
//			
//			
//
//return employeeEntity;


Optional <EmployeeEntity> employeeDB = this.employeeRepository.findById(t.getId());
if(employeeDB.isPresent()) {
	EmployeeEntity employeeUpdate = employeeDB.get();
	employeeUpdate.setId(t.getId());
	employeeUpdate.setUsername(t.getUsername());
	
	employeeUpdate.setPassword(t.getPassword());
	
	employeeUpdate.setEmail(t.getEmail());
	
	employeeUpdate.setPhone(t.getPhone());
	employeeUpdate.setFirstname(t.getFirstname());
	
	employeeUpdate.setLastname(t.getLastname());
	
	employeeUpdate.setRole(t.getRole());

	System.out.println("Here");
	employeeRepository.save(employeeUpdate);
	System.out.println("Save");
	System.out.println(employeeUpdate.toString());
	return employeeUpdate;
	
}else {
		
	  throw new ResourceNotFoundException("Record not found with id : " + t.getId());
}
	
	
	
}
	





/*
 * Find the Employee by ID
 * Refer the actual Employee repository from the mongo repository
 * Return it.
 */
@Override
public EmployeeEntity findById(String id) {
	return employeeRepository.getOrderById(id);
	
}



/*
 * DeleteByPunchID
 * Look into the Employee repository and refer to the object by the ID and delete it by ID
 * 
 */
@Override
public void DeleteUser(String t){
	
	employeeRepository.deleteById(t);

	
	
}




@Override
public EmployeeEntity findByUsername(String username) {

	/* This calls the findByUsername method from the RegisterRepository class
     * Will return a UserEntity when username is found in the database
	 * @param - String username
	 * @Return found username, 
	 * @throw new runtime exception
	 *
	 */

	return employeeRepository.findByUsername(username);
}
	
	
}






