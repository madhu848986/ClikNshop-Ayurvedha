package com.example.service;

import java.util.List;

import com.example.model.Order;

public interface OrderService {
	   Order placeOrder(Order order);

	    List<Order> getAllOrders();

	    List<Order> getUserOrders(Long userId);

	    Order updateOrder(Order order);

	    boolean deleteOrder(Long id);
}
