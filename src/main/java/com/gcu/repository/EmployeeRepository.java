package com.gcu.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.gcu.data.entity.EmployeeEntity;


/*
 * Employee Repository Class, This class extends the Mongo Repository and allows the developer to implement the Mongo Repository
 * @Param<EmployeeEntity, String>
 */
public interface  EmployeeRepository extends MongoRepository<EmployeeEntity, String> {

	/*
	 * Find the Username Repository Method, This method is used to initiate the Spring Security Login as well.
	 * @Param , String username
	 */
	EmployeeEntity findByUsername(String username);

	/*
	 * Find the Employee By the ID and call on the mongo repository.
	 * @Param , String ID
	 */
	EmployeeEntity getOrderById(String id);

}
