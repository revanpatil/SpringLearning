package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	 @Autowired
	 public EmployeeRestController(EmployeeService theEmployeeService) {
		 employeeService = theEmployeeService;
	}
	
	
	
	//Expose the Employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee = employeeService.findById(employeeId);
		
		return theEmployee;		
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		//Just in case pass out an employee Id 
		// Set it as 0 so they enter correct data 
		theEmployee.setId(0);
		
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		//Just in case pass out an employee Id 
		// Set it as 0 so they enter correct data 
	
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee = employeeService.findById(employeeId);
		if(theEmployee == null) {
			throw new RuntimeException("Employee Id not found" +employeeId);
		}
		
		employeeService.delete(employeeId);
		
		return "the deleted string is" +theEmployee;		
	}
}

