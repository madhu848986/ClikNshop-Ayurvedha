package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Order;

@Repository
public class OrderDaoImp implements OrderDao{
	 @Autowired
	    private JdbcTemplate jdbcTemplate;

	    @Override
	    public int save(Order order) {
	        String sql = "INSERT INTO orders (user_id, shop_id, product_id, quantity, total_price) VALUES (?, ?, ?, ?, ?)";
	        return jdbcTemplate.update(sql,
	                order.getUserId(), order.getShopId(),
	                order.getProductId(), order.getQuantity(),
	                order.getTotalPrice());
	    }

	    @Override
	    public List<Order> findByUser(Long userId) {
	        String sql = "SELECT * FROM orders WHERE user_id = ?";
	        return jdbcTemplate.query(sql, new Object[]{userId}, (rs, rowNum) -> {
	            Order o = new Order();
	            o.setId(rs.getLong("id"));
	            o.setUserId(rs.getLong("user_id"));
	            o.setShopId(rs.getLong("shop_id"));
	            o.setProductId(rs.getLong("product_id"));
	            o.setQuantity(rs.getInt("quantity"));
	            o.setTotalPrice(rs.getDouble("total_price"));
	            o.setOrderDate(rs.getTimestamp("order_date").toLocalDateTime());
	            return o;
	        });
	    }

}
