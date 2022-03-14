package com.gcu.business;



import java.util.List;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.gcu.data.entity.EmployeeEntity;

import com.gcu.model.EmployeeModel;


/*
 * Employee Service Interface that implements all the employee Methods
 * This calls on the spring beans Init and Destory
 * This also calls on the CRUD fucntionality methods and Login. 
 */
public interface EmployeeServiceInterface {
	
	
	public void init();
	public void destroy();
	public boolean login(EmployeeModel user);
	List<EmployeeModel> findAll();
	public EmployeeModel insertEmployee(EmployeeModel user);
	public EmployeeModel getEmployeebyID(String id);
	public EmployeeModel update(EmployeeModel t);
	public void Delete(String id);
}
