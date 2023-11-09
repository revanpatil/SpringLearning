package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//Need to inject the Session Factory
	@Autowired
	private SessionFactory sessionFactory;


	
	@Override
	public List<Customer> getCustomers() {
		//get a current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// Create a query 
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

		//Execcute a query and get results
		List<Customer> customers = theQuery.getResultList();

		//return the results
		return customers;
	}



	@Override
	public void saveCustomer(Customer theCustomer) {

		//get the current session 
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the customer
		currentSession.saveOrUpdate(theCustomer);
	}



	@Override
	public Customer getCustomers(int theId) {
		// get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//get the customer from database using primary key or id
		Customer theCustomer = currentSession.get(Customer.class, theId); 
		
		
		return theCustomer;
	}



	@Override
	public void deleteCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		currentSession.delete(theCustomer);
		
	}



	

}
