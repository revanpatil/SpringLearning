package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	//add a new method find Accounts
	public List<Account> findAccounts(boolean tripWire){
		if(tripWire) {
			throw new RuntimeException("No soup for you");
		}
		
		List<Account> myAccounts = new ArrayList();
		
		//Create Sample Accounts 
		Account temp1 = new Account("John","Silver");
		Account temp2 = new Account("Madhu","Gold");
		Account temp3 = new Account("Luca","Platinum");
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
		
	}
	
	
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
