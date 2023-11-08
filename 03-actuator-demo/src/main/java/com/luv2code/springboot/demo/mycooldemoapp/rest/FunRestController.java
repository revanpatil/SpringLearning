package com.luv2code.springboot.demo.mycooldemoapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	@Value("${captain.name}")
	private String captainName;
	
	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/")
	public String sayHello() {
		
		// expose "/" it will return hello world
		return "Hello world! Time on server is " +LocalDateTime.now(); 
	}
	
	@GetMapping("/workout")
	public String workOut() {
		
		// expose "/" it will return hello world
		return "Workout is on"; 
	}
	
	@GetMapping("/teaminfo")
	public String teamInfo() {
		
		return teamName + " "  +captainName;
	}
}
