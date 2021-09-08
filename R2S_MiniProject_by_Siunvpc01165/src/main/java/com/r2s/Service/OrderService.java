package com.r2s.Service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.r2s.Entity.Order;
import com.r2s.Entity.Product;

public interface OrderService {



	Order create(JsonNode orderData);

	Order findById(Long id);

	List<Order> findByUsername(String username);

}
