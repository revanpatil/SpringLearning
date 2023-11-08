package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	//Handle Code for Customer Not Found Exception
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc){
		
		//Create Customer Error Response
		CustomerErrorResponse error = new CustomerErrorResponse(
											HttpStatus.NOT_FOUND.value(), exc.getMessage(),
											System.currentTimeMillis());
		
		//return ResponseEntity
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	// Handle Code for any other type of Exception
	//Handle Code for Customer Not Found Exception
		@ExceptionHandler
		public ResponseEntity<CustomerErrorResponse> handleException(Exception exc){
			
			//Create Customer Error Response
			CustomerErrorResponse error = new CustomerErrorResponse(
												HttpStatus.BAD_REQUEST.value(), exc.getMessage(),
												System.currentTimeMillis());
			
			//return ResponseEntity
			return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		}
		
		

}
