package com.r2s.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.r2s.Entity.Account;



public interface AccountDAO extends JpaRepository<Account, String>{
@Query("SELECT DISTINCT ar.account FROM Authority ar Where ar.role.id IN ('ROPM','ADMI')")
	List<Account> getAdministrators();

}
