package com.gcu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gcu.business.EmployeeService;



///* This class is the Security Configuration file for the entire projcet 
// * This class will implment OAUTH and error checking to ensure that all pages except 
// * the Register and Login are secured.
// * @Configuration - automatically configure your app to make sure jar dependencies that have been added work 
// * @EnableWebSecurity - Marker Annotation, allows the application to appl the class global web security
// * WebSecurityConfigurerAdapter - This extended class comes from Spring, lets us use @Configuration and @EnableWebSecurity
// */
//
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer{
	
	 
	@Autowired 
	PasswordEncoder passwordEncoder;
	
	@Autowired
	EmployeeService service;
	
	
	

	  /* This method comes from the Spring Security
		 * @Bean - method level annotation managed by Spring Container 
		 * @return - a BCryptpassword encoder. (From the .crypto package 
		 *
		 */
		@Bean
		BCryptPasswordEncoder passwordEncoder()
		{
			return new BCryptPasswordEncoder();
		}
		
		
		/*This method analayzes all the request and authorizes them and permits them
		 * This method is the main method of implementing security for any authorization
		 * This references the parameters for the login and the logout functionality
		 * references the default sucess url
		 * invalidateHTTP sessions, and logout sucess
		 * Line 74 Secure the API's. The username(user) and password(pass) from MongoDB must be inserted in Postman to access them.
		 * @Param - HTTP security
		 * @Throws Exception
		 * @Return an instance of spring security configuration settings
		 */
		// This method secures all pages except for the register and login pages.
		@Override
		protected void configure(HttpSecurity http) throws Exception
		{
		
		
			
			http.csrf().disable()
			.httpBasic()
			.and()
			.authorizeRequests()
			.antMatchers("/service/**").authenticated() //
			.and()
			.authorizeRequests().antMatchers("/", "/images/**", "/displayOauthCode/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.usernameParameter("username")
				.passwordParameter("password")
				.permitAll()
				.defaultSuccessUrl("/", true)
				.and()
			.logout()
				.logoutUrl("/logout")
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.permitAll()
				.logoutSuccessUrl("/");
		}
		
		
		/* Autowiring an instance of AuthenticationManagerBuilder enables Web Security in the application
		 * encrypts a hardcoded value. The developer must manually input this in MongoDB.
		 * Set the userDetailsService() and passwordEncoder() on the auth parameter as follows:
		 * @Param  - AuthenticationManagerBuilder auth
		 * @Throws Exception handling
		 * @Return a detailsservice service and an encrypted authorized password 
		 */

		@Autowired
		public void configure(AuthenticationManagerBuilder auth) throws Exception
		{
			String password = new BCryptPasswordEncoder().encode("pass");
			
			auth
			.userDetailsService(service)
			.passwordEncoder(passwordEncoder);		

			System.out.println("Password: " + password);
		}

}
	
	
