package com.gcu.data;

import java.util.List;
import java.util.Optional;

import com.gcu.data.entity.EmployeeEntity;
import com.gcu.data.entity.TimeCardEntity;
import com.gcu.model.EmployeeModel;


/*
 * 
 * Interface for the Employee Data service methods
 * This is a Generic Interface that provides more flexibilty to the interfacae to inherit a variety of parameters. 
 */
public interface EmployeeDataAccessInterface <T> {

	public EmployeeEntity login(EmployeeModel user);
	List<EmployeeEntity> findAll();

	public EmployeeEntity create(EmployeeModel t);
	public EmployeeEntity findById(String id);
	
	public EmployeeEntity update(EmployeeEntity t);
	public void DeleteUser(String t);
	
	public T findByUsername(String username);
	
	
	
}
