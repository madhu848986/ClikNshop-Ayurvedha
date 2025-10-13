package com.example.repository;

import java.util.List;

import com.example.model.Order;

public interface OrderDao {

	int save(Order order);
    List<Order> findByUser(Long userId);
}
