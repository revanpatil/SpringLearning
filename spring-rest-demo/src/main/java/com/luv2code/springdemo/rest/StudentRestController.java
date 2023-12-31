package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	//define a private field for list 
	private List<Student> theStudents;

	//post contruct will only run the method at once 
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		theStudents.add(new Student("poornima","patel"));
		theStudents.add(new Student("Robert","Downey Jr"));
		theStudents.add(new Student("Will","Smith"));
	}

	//define endpoint for student list 
	@GetMapping("/students")
	public List<Student> getStudents(){

		return theStudents;
	}

	//define endpoint for "student/{studentId}" -> return student at index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		//checking the studentId against list
		if(studentId>=theStudents.size() || studentId <0) {
			throw new StudentNotFoundException("Student Not found " +studentId);
		}
		
		return theStudents.get(studentId);
	}
	
	
}
