package com.expensemanager.demoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expensemanager.demoapp.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
