package com.gcu.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.gcu.data.EmployeeDataService;

import com.gcu.data.entity.EmployeeEntity;

import com.gcu.model.EmployeeModel;


@Service
public class EmployeeService implements EmployeeServiceInterface, UserDetailsService{

	@Autowired
	EmployeeDataService service;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
		@Override
		public List<EmployeeModel> findAll() 
		{
			// TODO Auto-generated method stub
			// Get all the Entity Albums using the findAll() method from the AlbumDataService class.
			List<EmployeeEntity> userEntity = service.findAll();
			
			// Iterate over the Entity Albums and create a list of Domain Albums
			List<EmployeeModel> userdomain = new ArrayList<EmployeeModel>();
			for(EmployeeEntity entity : userEntity)
			{
				userdomain.add(new EmployeeModel(entity.getId(), entity.getUsername(), entity.getPassword(),entity.getEmail(),entity.getPhone(),entity.getFirstname(),entity.getLastname(),entity.getRole(), entity.getTimecard()));
				
			}
			
			return userdomain;	
		}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		System.out.println("line 60");
		// Make a UserEntity and call the data service method with the given username parameter
		EmployeeEntity user = service.findByUsername(username);
		if(user != null)
		{
			System.out.println("line 66");
			List<GrantedAuthority> authorites = new ArrayList<GrantedAuthority>();
			authorites.add(new SimpleGrantedAuthority("USER"));
			// User comes from UserDetailsService
			System.out.println("line 70");
			return new User(user.getUsername(), user.getPassword(), authorites);
			
		}
		else
		{
			System.out.println("75");
			throw new UsernameNotFoundException("username not found");
		}
	}


	@Override
	public String doLogin(EmployeeModel credentialsModel, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) 
		{
			model.addAttribute("title", "Login Form");			
			return "login";
		}	
		// See if the inputed values match hard coded values
		if(credentialsModel.getUsername().compareTo("User") != 0 && credentialsModel.getPassword().compareTo("Pass") != 0)  
		{				
			model.addAttribute("title", "Login Form");
			System.out.println("no");
			return "login"; // Keep the user at the login view					
		}		
	    //CredentialsModel test = service.doLogin(loginModel.getUsername(), loginModel.getPassword());
		System.out.println("yes");
		return "AdminControllerPage";
	}
	
	// DAO Login
	public boolean login(EmployeeModel user) {
		return service.login(user);
	}
	
	@Override
	public EmployeeModel insertEmployee(EmployeeModel user) {
		// TODO Auto-generated method stub
		EmployeeEntity newEmployee = service.create(user);
		
		return new EmployeeModel(newEmployee.getId(), newEmployee.getUsername(), newEmployee.getPassword(), newEmployee.getEmail(), newEmployee.getPhone(), newEmployee.getFirstname(), newEmployee.getLastname(), newEmployee.getRole(), newEmployee.getTimecard());
	}

//	@Override
//	public EmployeeModel getEmployeebyID(String id) {
//		
//	
//	}

	@Override
	public EmployeeModel update(EmployeeModel t) {
		// TODO Auto-generated method stub
		
		// Call the service update method
				EmployeeEntity employeeEntity = service.update(t);
				return ConvertEntity(employeeEntity);
	}
	@Override
	public EmployeeModel getEmployeebyID(String id) {
		EmployeeEntity employeeEntity = service.findById(id);
		
		return ConvertEntity(employeeEntity);
	}
	
	public EmployeeModel ConvertEntity(EmployeeEntity model) {
		return new EmployeeModel(model.getId(), model.getUsername(), model.getPassword(), model.getEmail(), model.getPhone(), model.getFirstname(), model.getLastname(), model.getRole(), model.getTimecard());
	}

	@Override
	public void Delete(String id) {
		// TODO Auto-generated method stub
		service.DeleteUser(id);
	}
	}
	
	
	
	
	


	


