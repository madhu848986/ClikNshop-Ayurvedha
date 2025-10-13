package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Product;

@Repository
public class ProductDaoImp implements ProductDao {
 

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Product product) {
        String sql = "INSERT INTO products (name, price) VALUES (?, ?)";
        return jdbcTemplate.update(sql, product.getName(), product.getPrice());
    }

    @Override
    public List<Product> findAll() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Product p = new Product();
            p.setId(rs.getLong("id"));
            p.setName(rs.getString("name"));
            p.setPrice(rs.getDouble("price"));
            return p;
        });
    }
    
  
    @Override
    public Product findById(Long id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        List<Product> products = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class), id);
        return products.isEmpty() ? null : products.get(0);
    }

    // Update an existing product
    @Override
    public int update(Product product) {
        String sql = "UPDATE products SET name = ?, description = ?, price = ? WHERE id = ?";
        return jdbcTemplate.update(sql, product.getName(), product.getDescription(), product.getPrice(),
               product.getId());
    }

    // Delete product by ID
    @Override
    public int deleteById(Long id) {
        String sql = "DELETE FROM products WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
	
}
