package com.r2s.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.r2s.Entity.Order;




public interface OrderDAO extends JpaRepository<Order, String>{

	Order findAllById(Long id);
	@Query("SELECT o FROM Order o WHERE o.account.username = ?1")
	List<Order> findByUsername(String username);

}
