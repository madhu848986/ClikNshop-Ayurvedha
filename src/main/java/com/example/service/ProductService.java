package com.example.service;

import java.util.List;

import com.example.model.Product;

public interface ProductService {
	   Product addProduct(Product product);
	    List<Product> getAllProducts();
		Product getProductById(Long id);
		boolean deleteProduct(Long id);
		Product updateProduct(Long id, Product product);

}
