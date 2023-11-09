package com.code.springdemo;

import java.util.Random;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		Random randomGenerator = new Random();
		String[] fortunes = {"Today is your lucky day!", "You'll have a great match", "Have a wonderful day"};
		return fortunes[randomGenerator.nextInt(3)];
	}

}
