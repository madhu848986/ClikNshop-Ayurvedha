package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Order;
import com.example.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	  @Autowired
	    private OrderService orderService;

	    @GetMapping
	    public List<Order> getAllOrders() {
	        return orderService.getAllOrders();
	    }

	    @GetMapping("/{id}")
	    public List<Order> getOrder(@PathVariable Long id) {
	        return orderService.getUserOrders(id);
	    }

	    @PostMapping
	    public Order createOrder(@RequestBody Order order) {
	        orderService.placeOrder(order);
	        return order;
	    }

	    @PutMapping("/{id}")
	    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
	        order.setId(id);
	        orderService.updateOrder(order);
	        return order;
	    }

	    @DeleteMapping("/{id}")
	    public String deleteOrder(@PathVariable Long id) {
	        orderService.deleteOrder(id);
	        return "Order deleted with id: " + id;
	    }

}
