package com.example.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Order;
import com.example.repository.OrderDao;


@Service
public class OrderServiceImpl implements OrderService{
	 @Autowired
	    private OrderDao orderDao;

	    @Override
	    public Order placeOrder(Order order) {
	        orderDao.save(order);
	        return order;
	    }

	    @Override
	    public List<Order> getAllOrders() {
	        return orderDao.findAll();
	    }

	    @Override
	    public List<Order> getUserOrders(Long userId) {
	        return orderDao.findByUserId(userId);
	    }

	    @Override
	    public Order updateOrder(Order order) {
	        orderDao.update(order);
	        return order;
	    }

	    @Override
	    public boolean deleteOrder(Long id) {
	        Order existing = orderDao.findById(id);
	        if (existing != null) {
	            orderDao.deleteById(id);
	            return true;
	        }
	        return false;
	    }

}
