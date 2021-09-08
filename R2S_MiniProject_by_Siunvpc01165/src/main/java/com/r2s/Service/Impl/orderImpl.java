package com.r2s.Service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.r2s.DAO.OrderDAO;
import com.r2s.DAO.OrderDetailDAO;
import com.r2s.Entity.Order;
import com.r2s.Entity.OrderDetail;
import com.r2s.Entity.Product;
import com.r2s.Service.OrderService;
@Service
public class orderImpl  implements OrderService{
	@Autowired
	OrderDAO dao;
	@Autowired
	OrderDetailDAO ddao;
	@Override
	public Order create(JsonNode orderData) {
		ObjectMapper mapper = new ObjectMapper();
		Order order = mapper.convertValue(orderData, Order.class);
		dao.save(order);
//		System.out.println("Success");
		TypeReference<List<OrderDetail>> type = new TypeReference< List<OrderDetail>>() {};
		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type)
				.stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
		ddao.saveAll(details);
		
			
		return order;
	}
	@Override
	public Order findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findAllById(id);
	}
	@Override
	public List<Order> findByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.findByUsername(username);
	}
	
	

}
