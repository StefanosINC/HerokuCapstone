package com.gcu.api.employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")

public class RestApiAuthentication {

	
	@GetMapping("/login")
	public void login() {
		
	}
}
