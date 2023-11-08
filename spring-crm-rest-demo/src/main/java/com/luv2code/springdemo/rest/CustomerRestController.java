package com.luv2code.springdemo.rest;

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

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {


	//Autowire the customerService
	@Autowired
	private CustomerService customerService;

	//Add Mapping to get customers

	@GetMapping("/customers")
	public List<Customer> getCustomer(){


		return customerService.getCustomers();
	}

	//	Add Mapping for /customers/{customerId}
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer theCustomer = customerService.getCustomer(customerId);

		if(theCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found " +customerId);
		}

		return theCustomer;

	}

	//Add Mapping for Post Customer - Add a Customer

	@PostMapping("customers")
	public Customer AddCustomer(@RequestBody Customer theCustomer) {
		theCustomer.setId(0);

		customerService.saveCustomer(theCustomer);

		return theCustomer;
	}

	//Add Mapping for Post Customer - Add a Customer

	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {

		customerService.saveCustomer(theCustomer);

		return theCustomer;
	}	

	//Add Mapping for Delete Customer - Delete a Customer
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		
		Customer tempCustomer = customerService.getCustomer(customerId);
		
		if(tempCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found " +customerId);
		}
		
		customerService.deleteCustomer(customerId);
		
		return "Deleted Customer is " +customerId;
	}
	
	
	
}
