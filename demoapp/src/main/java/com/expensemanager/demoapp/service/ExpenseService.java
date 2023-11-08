package com.expensemanager.demoapp.service;

import java.util.List;

import com.expensemanager.demoapp.model.Expense;

public interface ExpenseService {

	List<Expense> findAll();
	
	public void save(Expense expense);
	
	public Expense findById(Long id);
}
