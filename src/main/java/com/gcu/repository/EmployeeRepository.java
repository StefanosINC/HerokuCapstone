package com.gcu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gcu.data.entity.EmployeeEntity;
import com.gcu.model.EmployeeModel;

public interface  EmployeeRepository extends MongoRepository<EmployeeEntity, String> {

	EmployeeEntity findByUsername(String username);

	EmployeeEntity getOrderById(String id);

}
