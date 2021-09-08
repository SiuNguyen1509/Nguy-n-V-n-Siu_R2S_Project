package com.r2s.Service;

import java.util.List;

import com.r2s.Entity.Account;

public interface AccountService {
	public Account findById(String name);

	public List<Account> getAdministrators();

	public List<Account> findAll();
	
	public Account create(Account account);

	public Account update(Account account);

	public void deletefindById(String id);
}
