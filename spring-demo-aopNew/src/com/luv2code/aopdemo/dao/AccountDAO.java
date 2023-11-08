package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	
	public void addAccount(Account theAccount, boolean vizpack) {
		
		System.out.println(getClass()+ "Doing MY DB Work: Adding An Account");
	}
	
	public boolean goToSleep(boolean hello) {
		System.out.println(getClass()+"Go to sleep");
		return false;
	}

}
