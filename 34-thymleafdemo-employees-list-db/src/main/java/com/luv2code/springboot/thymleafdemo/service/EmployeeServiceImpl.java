package com.luv2code.springboot.thymleafdemo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	
	//injecting employee DAO with constructor Injection 
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		
		return employeeRepository.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {		
		
		
		Optional<Employee> result = employeeRepository.findById(id);
		
		Employee theEmployee = null;
		if(result.isPresent()) {
			theEmployee = result.get();
		}else {
			throw new RuntimeException();
		}
		return theEmployee;
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);

	}

	@Override
	@Transactional
	public void delete(int id) {
		employeeRepository.deleteById(id);
	}

}
