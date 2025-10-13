package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Stock;

@Repository
public class StockDaoImp implements StockDao {

	 @Autowired
	    private JdbcTemplate jdbcTemplate;

	    @Override
	    public int save(Stock stock) {
	        String sql = "INSERT INTO stock (shop_id, product_id, quantity, last_updated) VALUES (?, ?, ?, NOW())";
	        return jdbcTemplate.update(sql, stock.getShopId(), stock.getProductId(), stock.getQuantity());
	    }

	    @Override
	    public int updateStock(Long shopId, Long productId, int quantity) {
	        String sql = "UPDATE stock SET quantity = ?, last_updated = NOW() WHERE shop_id = ? AND product_id = ?";
	        return jdbcTemplate.update(sql, quantity, shopId, productId);
	    }

	    @Override
	    public List<Stock> findByShop(Long shopId) {
	        String sql = "SELECT * FROM stock WHERE shop_id = ?";
	        return jdbcTemplate.query(sql, new Object[]{shopId}, (rs, rowNum) -> {
	            Stock s = new Stock();
	            s.setId(rs.getLong("id"));
	            s.setShopId(rs.getLong("shop_id"));
	            s.setProductId(rs.getLong("product_id"));
	            s.setQuantity(rs.getInt("quantity"));
	            return s;
	        });
	    }
}
