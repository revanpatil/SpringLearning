package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public String getName() {
		System.out.println("Inside get Name");
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Inside Set name");
	}

	public String getServiceCode() {
		System.out.println("Inside set code");
		return serviceCode;
		
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
		System.out.println("Inside Service Code Method");
	}

	public void addAccount(Account theAccount, boolean vizpack) {
		
		System.out.println(getClass()+ "Doing MY DB Work: Adding An Account");
	}
	
	public boolean goToSleep(boolean hello) {
		System.out.println(getClass()+"Go to sleep");
		return false;
	}

}
