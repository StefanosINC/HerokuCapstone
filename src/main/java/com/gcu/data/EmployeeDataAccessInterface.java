package com.gcu.data;

import java.util.List;
import java.util.Optional;

import com.gcu.data.entity.EmployeeEntity;

import com.gcu.model.EmployeeModel;



public interface EmployeeDataAccessInterface <T> {

	public boolean login(EmployeeModel user);
	
	public List<EmployeeEntity> FindAllEmployees();
	
	public T findByUsername(String username);

	List<EmployeeEntity> findAll();

	public EmployeeEntity create(EmployeeModel t);
	public EmployeeEntity findById(String id);
	
	public EmployeeEntity update(EmployeeModel t);
	public void DeleteUser(String t);
}
