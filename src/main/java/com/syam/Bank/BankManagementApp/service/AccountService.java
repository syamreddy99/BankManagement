package com.syam.Bank.BankManagementApp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.syam.Bank.BankManagementApp.entity.Account;

public interface AccountService {
    public ResponseEntity<Account> createAccount(Account account);
    public Account getAccountDetailsByAccountNumber(long accountNumber);
    public List<Account> getAccountDetails();
    public Account depositAmount(long accountNumber, double depositedMoney);
    public Account withdrawMoney(long accountNumber, double withdrawMoney);
    public String closeAccount(long accountNumber);
}
