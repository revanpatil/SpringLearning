package com.luv2code.springboot.demo.mycooldemoapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	@GetMapping("/")
	public String sayHello() {
		
		// expose "/" it will return hello world
		return "Hello world! Time on server is " +LocalDateTime.now(); 
	}
	
}
