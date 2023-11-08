package com.luv2code.springboot.cruddemo.dao;

import java.util.List;
import java.util.Queue;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	//Define feild for entityManager
	private EntityManager entityManager;
	
	//Setup Constructor Injection
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		
		//Get the current hibernate Session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//Create the query
		Query<Employee>theQuery= currentSession.createQuery("from Employee",Employee.class);
		
		//Execute the query and get the result
		List<Employee> employees = theQuery.getResultList();
		
		//return the result 
		return employees;
	}


	@Override
	public Employee findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee theQuery = currentSession.get(Employee.class,theId);
		
		
		return theQuery;
	}


	@Override
	public void save(Employee theEmployee) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theEmployee);
		
		
	}


	@Override
	public void delete(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId"); 
		
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
		
	}

}
