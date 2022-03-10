package com.gcu.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.gcu.data.entity.TimeCardEntity;


/*
 * Time Card Repository Class that allows the TimeCard to implement the MongoRepository
 * @Param <TimeCardEntity, String>
 */
public interface TimeCardRepository extends MongoRepository<TimeCardEntity, String>{

	
	/*
	 * This method utilizes the MongoRepository to find the timecard ID, 
	 * @Param String id
	 */
	TimeCardEntity findTimeCardById(String id);
}
