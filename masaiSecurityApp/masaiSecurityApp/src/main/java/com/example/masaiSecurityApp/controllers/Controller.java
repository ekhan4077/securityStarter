package com.example.masaiSecurityApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.masaiSecurityApp.employee.Employee;
import com.example.masaiSecurityApp.employee.EmployeeDao;

@RestController
@RequestMapping("/masai")
public class Controller {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/welcome")
	public ResponseEntity<String> welcome(){
		
	 return new ResponseEntity<String>("Welcome to Masai App without security",HttpStatus.
   ACCEPTED);
	}
		
	
	@GetMapping("/welcomeP")
	public ResponseEntity<String> welcomeP(){
		
			return new ResponseEntity<String>("Welcome to Masai App with Security",HttpStatus
     .ACCEPTED);
	}

	@GetMapping("/admin")
	public ResponseEntity<String> admin(){
		
		return new ResponseEntity<String>("Welcome to Masai App for Admin",HttpStatus.
					 ACCEPTED);
		}
	
	@PostMapping("/employee/register")
	public ResponseEntity<Employee> register(@RequestBody Employee employee){
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		Employee employee2 = employeeDao.save(employee);
		return new ResponseEntity<Employee>(employee2, HttpStatus.OK);
	}
	
}
