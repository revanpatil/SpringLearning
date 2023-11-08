package com.expensemanager.demoapp.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tbl_expenses")
@Getter
@Setter
@ToString
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="dscription")
	private String expenseDscriptions;
	
	@Column(name="amount")
	private BigDecimal amount;
	
	@Column(name="note")
	private String note;
	
	@Column(name="created_at")
	private long createdAt;

	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getExpenseDscriptions() {
		return expenseDscriptions;
	}


	public void setExpenseDscriptions(String expenseDscriptions) {
		this.expenseDscriptions = expenseDscriptions;
	}


	public BigDecimal getAmount() {
		return amount;
	}


	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public long getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}


	@Override
	public String toString() {
		return "Expense [id=" + id + ", expenseDscriptions=" + expenseDscriptions + ", amount=" + amount + ", note="
				+ note + ", createdAt=" + createdAt + "]";
	}
	
	
}
