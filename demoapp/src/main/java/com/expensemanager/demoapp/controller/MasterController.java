package com.expensemanager.demoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.expensemanager.demoapp.model.Expense;
import com.expensemanager.demoapp.service.ExpenseService;

@Controller
public class MasterController {

	@Autowired
	ExpenseService expenseService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mov = new ModelAndView("home");
		mov.addObject("message","List of Expenses");
		List<Expense> expenses = expenseService.findAll();
		mov.addObject("expenses",expenses);
		System.out.println(expenses);
		return mov;
	}
	
	@RequestMapping("/expense")
	public ModelAndView addExpense() {
		ModelAndView mov = new ModelAndView("expense");
		mov.addObject("expense",new Expense());
		return mov;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute("expense") Expense expense) {
		expenseService.save(expense);
		return "redirect:/";
	}
	
	@RequestMapping(value="/expense/{id}", method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mov = new ModelAndView("expense");
		Expense expense =  expenseService.findById(id);
		mov.addObject("expense",expense);
		return mov;
	}
}
