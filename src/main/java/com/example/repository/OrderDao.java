package com.example.repository;

import java.util.List;

import com.example.model.Order;

public interface OrderDao {

	int save(Order order);
    List<Order> findAll();
    List<Order> findByUserId(Long userId);
    int update(Order order);
    int deleteById(Long id);
    Order findById(Long id);
}
