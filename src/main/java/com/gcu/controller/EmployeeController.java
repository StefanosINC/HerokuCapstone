package com.gcu.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.business.EmployeeServiceInterface;
import com.gcu.data.EmployeeDataAccessInterface;
import com.gcu.data.entity.EmployeeEntity;
import com.gcu.model.EmployeeModel;
import com.gcu.repository.EmployeeRepository;






@Controller
//@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceInterface employeeservice;
	
	
	
	@Autowired
	private EmployeeDataAccessInterface dataservice;
	
	@Autowired
	EmployeeRepository rep;
	// Login
	@GetMapping("/login")
	public String display(Model model) {
		model.addAttribute("title", "");
		return "index";
	}
	


	@GetMapping("/ViewEmployees")
	public String displayEmployees(Model model) {
	
		
		// get employee List from the service -> Database
		List<EmployeeModel> employeeList = employeeservice.findAll();
		
		
		System.out.println(employeeList);
		// Set the title attribute (from common)
//		model.addAttribute("title", "View Employees");
		
		// add the employee attribute which is in list of employees
		model.addAttribute("employeeList", employeeList);
		System.out.println(employeeList);
		return "ViewEmployeesForm";
	}
	
	
	
	@GetMapping("/RegForm")
	public String displayReg(Model model) {
	//	model.addAttribute("title", "N Form");
		
		model.addAttribute("employeeModel", new EmployeeModel());
		
		return "NewEmployeeForm";
	}
	
	// Register Form
	@PostMapping("/create")
	public String doRegister(EmployeeModel employee, BindingResult bindingResult, Model model) {

			EmployeeModel newEmployee = employeeservice.insertEmployee(employee);		
			
			employeeservice.insertEmployee(newEmployee);
		
			List<EmployeeModel> employeeList = employeeservice.findAll();
			
			model.addAttribute("employeeList", employeeList);
			
			return "ViewEmployeesForm";

	
		}
	@GetMapping("/Cards")
	public String displayCards(Model model) {
		
		
		return "EmployeeCards.html";
	}
	
	
	@GetMapping("/editForm")
	public String displayEditForm(@RequestParam("id") String id, Model model)
	{
		
		
		EmployeeModel foundEmployee = employeeservice.getEmployeebyID(id);
		
		System.out.println(foundEmployee.getEmployee_id());
		System.out.println("Employee info is " + foundEmployee.getUsername());
		model.addAttribute("title", "");
		model.addAttribute("employee", foundEmployee);
		return "EditEmployeeForm";
	}
	
	 
		@PostMapping("/edit")
		public String edit(EmployeeModel employee, BindingResult bindingResult, Model model)
		{
	
			EmployeeModel test = employeeservice.update(employee);
			System.out.println(test.getEmployee_id());
			
			
			model.addAttribute("employee", test);
		
			return "AdminControllerPage";
		}	
		
		@GetMapping("/delete")
		public String displayDeleteForm(@RequestParam("id") String id, Model model) 
		{	
			
				EmployeeModel foundAlbum = employeeservice.getEmployeebyID(id);
		
				System.out.println(foundAlbum.getUsername());
			
				model.addAttribute("employee", foundAlbum);
			
			
			return "DeleteConfirmation";
			
			
			
		
	
}
		
		@PostMapping("/processdelete")
		public String deleteAlbum(@RequestParam("id") String id, EmployeeModel album, Model model)
		{	
			System.out.println("Index: " + album);
			
			
			EmployeeModel foundEmployee = employeeservice.getEmployeebyID(id);
			
			foundEmployee.setEmployee_id(id);
			
			employeeservice.Delete(id);
				//EmployeeModel idAlbum = employeeservice.getEmployeebyID(id);
				
				//employeeservice.Delete(album.getEmployee_id());			
				System.out.println("Deleted Album is " + album);
				
				model.addAttribute("title", "");
				model.addAttribute("album", album);
			
		
			
			return "index";
		}
		
	
		
}
		
		
		
		
		
		
		
		
		
		
		
		

		
		
