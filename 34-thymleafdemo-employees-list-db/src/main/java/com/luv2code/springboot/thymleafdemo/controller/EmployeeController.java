package com.luv2code.springboot.thymleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.thymleafdemo.entity.Employee;
import com.luv2code.springboot.thymleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	
	//add mapping for the list
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		// Get db from database
		
		List<Employee> theEmployees = employeeService.findAll();
		
		//add the data to spring model 
		theModel.addAttribute("employees",theEmployees);
		return "list-employees";
	}
	
}
