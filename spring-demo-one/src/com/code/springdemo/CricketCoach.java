package com.code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;

public class CricketCoach implements Coach{

	private FortuneService fortuneService;
	private String emailAddress;
	private String team;
	
	public CricketCoach() {
		System.out.println("CricketCoach: Inside no-arg constructor");
	}
	
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: Inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}
	
	
	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: Inside the setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}


	public String getTeam() {
		return team;
	}


	public void setTeam(String team) {
		System.out.println("CricketCoach: Inside the setter method - setTeam");
		this.team = team;
	}


	@Override
	public String dailyWorkout() {
		return "Try 10 over practice cricket matches";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	//Add an init method
	public void doMyStartUpStuff() {
		System.out.println("Inside the init method - doMyStartUpStuff");
	}
	
	//Add a destroy method
	public void doMyCleanUpStuff() {
		System.out.println("Inside the destroy method - doMyCleanUpStuff");
	}

}
