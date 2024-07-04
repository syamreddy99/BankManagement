package com.syam.Bank.BankManagementApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syam.Bank.BankManagementApp.entity.Account;
import com.syam.Bank.BankManagementApp.service.AccountService;

@RestController
@RequestMapping("/Account")
public class AccountController{
	// create the Account
	
    @Autowired
    AccountService Service;

   //http://localhost:9976/Account/create
	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		ResponseEntity<Account> createAccount = Service.createAccount(account);
		
		return createAccount;
		}
   // get account details by account number 
	
	
	
	 // Get account details by account number
    // http://localhost:9976/Account/{accountNumber}
    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> getAccountDetailsByAccountNumber1(@PathVariable Long accountNumber) {
        Account accountDetails = Service.getAccountDetailsByAccountNumber(accountNumber);
        return new ResponseEntity<>(accountDetails, HttpStatus.OK);
    }

    // Get all account details
    // http://localhost:9976/Account/allAccountsDetails
    @GetMapping("/allAccountsDetails")
    public ResponseEntity<List<Account>> getAccountDetails() {
        List<Account> allAccounts = Service.getAccountDetails();
        return new ResponseEntity<>(allAccounts, HttpStatus.OK);
    }

    // Deposit money into an account
    // http://localhost:9976/Account/deposit/{accountNumber}/{depositedMoney}
    @PostMapping("/deposit/{accountNumber}/{depositedMoney}")
    public ResponseEntity<Account> depositMoney(@PathVariable long accountNumber, @PathVariable double depositedMoney) {
        System.out.println("Account Number: " + accountNumber + ", Deposited Money: " + depositedMoney);
        Account updatedAccount = Service.depositAmount(accountNumber, depositedMoney);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

    // Withdraw money from an account
    // http://localhost:9976/Account/withdraw/{accountNumber}/{withdrawMoney}
    @PostMapping("/withdraw/{accountNumber}/{withdrawMoney}")
    public ResponseEntity<Account> withdrawMoney(@PathVariable long accountNumber, @PathVariable double withdrawMoney) {
        Account updatedAccount = Service.withdrawMoney(accountNumber, withdrawMoney);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

    // Close an account
    // http://localhost:9976/Account/close/{accountNumber}
    @PostMapping("/close/{accountNumber}")
    public ResponseEntity<String> closeAccount(@PathVariable long accountNumber) {
    	 Service.closeAccount(accountNumber);
        return new ResponseEntity<>("Account Deleted  Successfully",HttpStatus.OK);
    }
}


