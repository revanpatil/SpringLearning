package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandlerClass {

	//Handle Exception using @Exception Handler
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse>handleException(StudentNotFoundException exe){
			
			StudentErrorResponse error = new StudentErrorResponse();
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMessage(exe.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		}
		
		//add another exception to catch all type of exception 
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse>handleException(Exception e){
			StudentErrorResponse error = new StudentErrorResponse();
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMessage(e.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
			
		}

}
