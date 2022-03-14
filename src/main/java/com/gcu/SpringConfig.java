package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.context.annotation.SessionScope;

import com.gcu.business.EmployeeService;
import com.gcu.business.EmployeeServiceInterface;
import com.gcu.business.TimeCardService;
import com.gcu.business.TimeCardServiceInterface;

/*
 * Spring Config class that is going to Create the Employee Service and the TimeCard Service Beans
 * @Configuration
 */
@Configuration
public class SpringConfig {

	/*
	 * Spring bean object Employee Service ( init , destroy)
	 */
  @Bean  (name="EmployeeService", initMethod="init", destroyMethod="destroy")
  @SessionScope
  @Primary
		public EmployeeServiceInterface doCredentialsService() 
{
	        return new EmployeeService();
	}
  
  /*
   * Spring bean object TimeCard Service ( init , destroy)
   * 
   */
  @Bean  (name="TimeCardService", initMethod="init", destroyMethod="destroy")
  @SessionScope
  @Primary
		public TimeCardServiceInterface create() 
{
	        return new TimeCardService();
	}
}
