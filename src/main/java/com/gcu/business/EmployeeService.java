package com.gcu.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.gcu.data.EmployeeDataService;

import com.gcu.data.entity.EmployeeEntity;

import com.gcu.model.EmployeeModel;

/*
 * This is the employee service class that implements the EmployeeServiceInterface class
 * This class inherits all the CRUD functionality and the Login feature for the employee
 * This class also imports the dataservice
 * Also this class inherits the spring bean objects , init , destroy 
 */
@Service
public class EmployeeService implements EmployeeServiceInterface{

	/*
	 * Import the Employee DataService methods 
	 * @Autwire the object in.
	 */
	@Autowired
	EmployeeDataService service;
	
	/*
	 * Spring bean Init
	 */
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Spring bean destroy
	 */
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	/* Loop through the Employee list objects and Find all the Employees. 
	 * Refer the Findall from the dataservice
	 * Create a new list and then add the entitys to the domain object.
	 * Return the object that has all the employee objects.
	 * 
	 */
		@Override
		public List<EmployeeModel> findAll() 
		{
		
			List<EmployeeEntity> userEntity = service.findAll();
			
			List<EmployeeModel> userdomain = new ArrayList<EmployeeModel>();
			for(EmployeeEntity entity : userEntity)
			{
				userdomain.add(new EmployeeModel(entity.getId(), entity.getUsername(), entity.getPassword(),entity.getEmail(),entity.getPhone(),entity.getFirstname(),entity.getLastname(),entity.getRole()));
				
			}
			
			return userdomain;	
		}

	
		/*
		 * Create Employee Object.
		 * Create a Employee object Entity and and refer to the dataservice create.
		 * Once you refer the data service return the Employee object
		 * 
		 */	
	@Override
	public EmployeeModel insertEmployee(EmployeeModel user) {
		// TODO Auto-generated method stub
		EmployeeEntity newEmployee = service.create(user);
		
		return new EmployeeModel(newEmployee.getId(), newEmployee.getUsername(), newEmployee.getPassword(), newEmployee.getEmail(), newEmployee.getPhone(), newEmployee.getFirstname(), newEmployee.getLastname(), newEmployee.getRole());
	}


	
	/*
	 * Employee Model to update the Employee object
	 * call on the data service and set it to the object in the parameters
	 * return the employee entity once converting back into the model
	 */
//	@Override
//	public EmployeeModel update(EmployeeModel t) {
//
//	EmployeeEntity employeeEntity = service.update(t);
//	return ConvertEntity(employeeEntity);
//	}
//	
	
	/*
	 * Set the Employee Object = to the service.FindByID
	 * Return Employee Object and call on the convert entity to reduce code. 
	 */
	
	
	@Override
	public EmployeeModel getEmployeebyID(String id) {
		EmployeeEntity employeeEntity = service.findById(id);
		
		return ConvertEntity(employeeEntity);
	}
	
	/*
	 * Take the Employee Entity and convert it into the Model
	 * Return the Employee Model
	 */
	public EmployeeModel ConvertEntity(EmployeeEntity model) {
		return new EmployeeModel(model.getId(), model.getUsername(), model.getPassword(), model.getEmail(), model.getPhone(), model.getFirstname(), model.getLastname(), model.getRole());
	}

	/*
	 * Delete the Employee Object.
	 * Call on the service and refer to the delte user and return the id 
	 */
	@Override
	public void Delete(String id) {
		// TODO Auto-generated method stub
		service.DeleteUser(id);
	}

	/*
	 * 
	 * Login method not created yet 
	 * 
	 */
	@Override
	public boolean login(EmployeeModel user) {
	

		return service.login(user);		
	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		EmployeeEntity user = service.findByUsername(username);
//		if(user != null)
//		{
//			List<GrantedAuthority> authorites = new ArrayList<GrantedAuthority>();
//			authorites.add(new SimpleGrantedAuthority("USER"));
//			
//			return new User(user.getUsername(), user.getPassword(), authorites);
//		}
//		else
//		{
//			throw new UsernameNotFoundException("username not found");
//		}
//	}
	
	
	}
	
	
	
	
	


	


