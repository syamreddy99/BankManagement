package com.syam.Bank.BankManagementApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Account {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long AccountNumber;
	@Column
	private String Account_holder_name ;
	@Column
	private Double Account_balance;
	public Account() {
		
	}
	public Account(String account_holder_name, Double account_balance) {
		super();
		Account_holder_name = account_holder_name;
		Account_balance = account_balance;
	}
	public long getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		AccountNumber = accountNumber;
	}
	public String getAccount_holder_name() {
		return Account_holder_name;
	}
	public void setAccount_holder_name(String account_holder_name) {
		Account_holder_name = account_holder_name;
	}
	public Double getAccount_balance() {
		return Account_balance;
	}
	public void setAccount_balance(Double account_balance) {
		Account_balance = account_balance;
	}
	@Override
	public String toString() {
		return "Account [AccountNumber=" + AccountNumber + ", Account_holder_name=" + Account_holder_name
				+ ", Account_balance=" + Account_balance + "]";
	}
}
