package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	//Constructor injection for entityManager
	
	@Autowired
	public EmployeeDAOJPAImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		//Create a Query
		Query theQuery = entityManager.createQuery("from Employee");
		
		//Execute the Query and get the Results
		List<Employee> employees = theQuery.getResultList();
		
		//return the results
		return employees;
	}

	@Override
	public Employee findById(int id) {
		Employee theEmployee = entityManager.find(Employee.class, id);
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		//Save or update theEmployee
		Employee dbEmployee = entityManager.merge(theEmployee);
		
		//Update with Id from db.. So we can get generated id from save/insert
		theEmployee.setId(dbEmployee.getId());
	}

	@Override
	public void delete(int id) {
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", id);
		theQuery.executeUpdate();
	}

}
