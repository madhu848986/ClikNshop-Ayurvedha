package com.example.repository;

import java.util.List;

import com.example.model.Product;

public interface ProductDao {
	 int save(Product product);
	    List<Product> findAll();
}
