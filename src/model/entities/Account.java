package model.entities;

import model.exception.DomainException;

public final class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		if(amount > balance) {
			throw new DomainException("Not enough balance.");
		}
		else if(amount > withdrawLimit) {
			throw new DomainException("The amount exceeds withdraw limit.");
		}
		
		balance -= amount;
	}
	
	public String toString() {
		return "New balance: " + String.format("%.2f", balance); 
	}

}
