package com.r2s.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.r2s.Entity.Account;
import com.r2s.Entity.Authority;
import com.r2s.Entity.Category;

public interface AuthorityDAO  extends JpaRepository<Authority, Integer>{

	
@Query("SELECT DISTINCT a FROM Authority a where a.account IN ?1 ")
List<Authority> AuthorityOf(List<Account> accounts);




}
