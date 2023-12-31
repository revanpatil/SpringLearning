package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		
		//simulate the delay 
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//return the Fortune
		return "Expect Heavy traffice this morning";
	}

	public String getFortune(boolean tripWire){
		if(tripWire) {
			throw new RuntimeException("Major accident on Highway");
		}
		
		return getFortune();
	}
}
