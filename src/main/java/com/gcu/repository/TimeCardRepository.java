package com.gcu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gcu.data.entity.TimeCardEntity;
public interface TimeCardRepository extends MongoRepository<TimeCardEntity, String>{

	
	
	TimeCardEntity findTimeCardById(String id);
}
