package com.luv2code.springboot.thymleafdemo.service;

import java.util.List;

import com.luv2code.springboot.thymleafdemo.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();

	public Employee findById(int id);

	public void save(Employee theEmployee);

	public void delete(int id);
}
