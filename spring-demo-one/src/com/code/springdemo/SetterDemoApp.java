package com.code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		
		//Load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Retrieve the bean from spring container
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		//Call the methods on the bean
		System.out.println(theCoach.dailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		//Call the new getter methods
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		
		//Close the context
		context.close();
	}

}
