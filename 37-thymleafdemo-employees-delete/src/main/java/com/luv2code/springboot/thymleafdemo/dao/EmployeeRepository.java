package com.luv2code.springboot.thymleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
	// Add method to sort by latName
	
	public List<Employee> findAllByOrderByLastNameAsc();
}
