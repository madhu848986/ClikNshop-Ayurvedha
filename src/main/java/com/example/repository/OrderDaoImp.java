package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
	    public List<Order> findByUserId(Long userId) {
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
	    

	    @Override
	    public List<Order> findAll() {
	        String sql = "SELECT * FROM orders";
	        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class));
	    }
	    
	    @Override
	    public int update(Order order) {
	        String sql = "UPDATE orders SET shop_id=?, product_id=?, quantity=?, total_price=? WHERE id=?";
	        return jdbcTemplate.update(sql, order.getShopId(), order.getProductId(), order.getQuantity(),
	                order.getTotalPrice(), order.getId());
	    }

	    @Override
	    public int deleteById(Long id) {
	        String sql = "DELETE FROM orders WHERE id=?";
	        return jdbcTemplate.update(sql, id);
	    }

	    @Override
	    public Order findById(Long id) {
	        String sql = "SELECT * FROM orders WHERE id=?";
	        List<Order> orders = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class), id);
	        return orders.isEmpty() ? null : orders.get(0);
	    }

}
