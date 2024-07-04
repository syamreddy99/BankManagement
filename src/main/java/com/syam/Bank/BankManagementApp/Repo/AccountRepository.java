package com.syam.Bank.BankManagementApp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syam.Bank.BankManagementApp.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {

}
