package com.code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		//Step 1: load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Step 2: Retrieve the bean from the container
		Coach theCoach = context.getBean("myCoachTrack", Coach.class);
		
		//Step 3: Call the methods on the bean
		System.out.println(theCoach.dailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		//Step 4: Close the application context
		context.close();
	}

}
