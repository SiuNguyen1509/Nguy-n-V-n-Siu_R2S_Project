package com.r2s.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.r2s.Entity.OrderDetail;


public interface OrderDetailDAO extends JpaRepository<OrderDetail, String>{

}
