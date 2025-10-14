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
        String sql = "INSERT INTO products (name, price, description, category, expiry_date, image_url) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, 
            product.getName(), 
            product.getPrice(),
            product.getDescription(),
            product.getCategory(),
            product.getExpiry_date(),
            product.getImage_url()
        );
    }
    @Override
    public List<Product> findAll() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Product p = new Product();
            p.setId(rs.getLong("id"));
            p.setName(rs.getString("name"));
            p.setPrice(rs.getDouble("price"));
            p.setDescription(rs.getString("description"));
            p.setCategory(rs.getString("category"));
            p.setExpiry_date(rs.getDate("expiry_date"));
            p.setImage_url(rs.getString("image_url"));
            return p;
        });
    }
    
    @Override
    public Product findById(Long id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        List<Product> products = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Product p = new Product();
            p.setId(rs.getLong("id"));
            p.setName(rs.getString("name"));
            p.setPrice(rs.getDouble("price"));
            p.setDescription(rs.getString("description"));
            p.setCategory(rs.getString("category"));
            p.setExpiry_date(rs.getDate("expiry_date"));
            p.setImage_url(rs.getString("image_url"));
            return p;
        }, id);
        return products.isEmpty() ? null : products.get(0);
    }

    
    @Override
    public int update(Product product) {
        String sql = "UPDATE products SET name = ?, description = ?, price = ?, category = ?, expiry_date = ?, image_url = ? WHERE id = ?";
        return jdbcTemplate.update(sql, 
            product.getName(), 
            product.getDescription(), 
            product.getPrice(),
            product.getCategory(),
            product.getExpiry_date(),
            product.getImage_url(),  
            product.getId()
        );
    }

    
    @Override
    public int deleteById(Long id) {
        String sql = "DELETE FROM products WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
	
}
