package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.example.model.Shop;

@Repository
public class ShopDaoImp implements ShopDao {
	  @Autowired
	    private JdbcTemplate jdbcTemplate;

	    @Override
	    public void save(Shop shop) {
	        String sql = "INSERT INTO shops (name, city, latitude, longitude, isOpen, lastUpdated) VALUES (?, ?, ?, ?, ?, NOW())";
	        jdbcTemplate.update(sql,
	                shop.getName(),
	                shop.getCity(),
	                shop.getLatitude(),
	                shop.getLongitude(),
	                shop.getIsOpen());
	    }

	    @Override
	    public void update(Shop shop) {
	        String sql = "UPDATE shops SET name=?, city=?, latitude=?, longitude=?, isOpen=?, lastUpdated=NOW() WHERE id=?";
	        jdbcTemplate.update(sql,
	                shop.getName(),
	                shop.getCity(),
	                shop.getLatitude(),
	                shop.getLongitude(),
	                shop.getIsOpen(),
	                shop.getId());
	    }

	    @Override
	    public void delete(Long id) {
	        String sql = "DELETE FROM shops WHERE id = ?";
	        jdbcTemplate.update(sql, id);
	    }

	    @Override
	    public Shop findById(Long id) {
	        String sql = "SELECT * FROM shops WHERE id = ?";
	        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
	            Shop shop = new Shop();
	            shop.setId(rs.getLong("id"));
	            shop.setName(rs.getString("name"));
	            shop.setCity(rs.getString("city"));
	            shop.setLatitude(rs.getDouble("latitude"));
	            shop.setLongitude(rs.getDouble("longitude"));
	            shop.setIsOpen(rs.getBoolean("isOpen"));
	            shop.setLastUpdated(rs.getTimestamp("lastUpdated").toLocalDateTime());
	            return shop;
	        });
	    }

	    @Override
	    public List<Shop> findAll() {
	        String sql = "SELECT * FROM shops";
	        return jdbcTemplate.query(sql, (rs, rowNum) -> {
	            Shop shop = new Shop();
	            shop.setId(rs.getLong("id"));
	            shop.setName(rs.getString("name"));
	            shop.setCity(rs.getString("city"));
	            shop.setLatitude(rs.getDouble("latitude"));
	            shop.setLongitude(rs.getDouble("longitude"));
	            shop.setIsOpen(rs.getBoolean("isOpen"));
	            shop.setLastUpdated(rs.getTimestamp("lastUpdated").toLocalDateTime());
	            return shop;
	        });
	    }

	    @Override
	    public List<Shop> findShopsWithProduct(Long productId) {
	        String sql = "SELECT s.* FROM shops s " +
	                     "JOIN stock st ON s.id = st.shop_id " +
	                     "WHERE st.product_id = ? AND st.quantity > 0";
	        return jdbcTemplate.query(sql, new Object[]{productId}, (rs, rowNum) -> {
	            Shop shop = new Shop();
	            shop.setId(rs.getLong("id"));
	            shop.setName(rs.getString("name"));
	            shop.setCity(rs.getString("city"));
	            shop.setLatitude(rs.getDouble("latitude"));
	            shop.setLongitude(rs.getDouble("longitude"));
	            shop.setIsOpen(rs.getBoolean("isOpen"));
	            shop.setLastUpdated(rs.getTimestamp("lastUpdated").toLocalDateTime());
	            return shop;
	        });
	    }

	
}
