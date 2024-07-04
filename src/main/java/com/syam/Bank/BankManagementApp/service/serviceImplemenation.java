package com.syam.Bank.BankManagementApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.syam.Bank.BankManagementApp.Repo.AccountRepository;
import com.syam.Bank.BankManagementApp.entity.Account;

@Service
public class serviceImplemenation implements AccountService {
	
	@Autowired
	AccountRepository AREPO;
	

	@Override
	public ResponseEntity<Account> createAccount(Account account) { // it gives 200 ok only if i need Crated 201 then we need ato apply 
		Account account_save = AREPO.save(account); // AccountEntity<Account>
		Account ac = new Account();
		System.out.println(ac.getAccount_balance());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(account_save);
	}

	 @Override
	    public Account getAccountDetailsByAccountNumber(long accountNumber) {
	        Optional<Account> accountOptional = AREPO.findById(accountNumber);
	        if (accountOptional.isPresent()) {
	            return accountOptional.get();
	        } else {
	            throw new RuntimeException("Account with number " + accountNumber + " not found");
	        }
	    }

	    @Override
	    public List<Account> getAccountDetails() {
	        return AREPO.findAll();
	    }

	    @Override
	    public Account depositAmount(long accountNumber, double depositedMoney) {
	        Optional<Account> accountOptional = AREPO.findById(accountNumber);
	        if (accountOptional.isPresent()) {
	            Account account = accountOptional.get();
	            account.setAccount_balance(account.getAccount_balance() + depositedMoney);
	            return AREPO.save(account);
	        } else {
	            throw new RuntimeException("Account with number " + accountNumber + " not found");
	        }
	    }

	    @Override
	    public Account withdrawMoney(long accountNumber, double withdrawMoney) {
	        Optional<Account> accountOptional = AREPO.findById(accountNumber);
	        if (accountOptional.isPresent()) {
	            Account account = accountOptional.get();
	            double newBalance = account.getAccount_balance() - withdrawMoney;
	            if (newBalance < 0) {
	                throw new RuntimeException("Insufficient funds in account with number " + accountNumber);
	            }
	            account.setAccount_balance(newBalance);
	            return AREPO.save(account);
	        } else {
	            throw new RuntimeException("Account with number " + accountNumber + " not found");
	        }
	    }

	    @Override
	    public String closeAccount(long accountNumber) {
	        if (AREPO.existsById(accountNumber)) {
	            AREPO.deleteById(accountNumber);
	        } else {
	            throw new RuntimeException("Account with number " + accountNumber + " not found");
	        }
			return "deleted";
	    }

}
