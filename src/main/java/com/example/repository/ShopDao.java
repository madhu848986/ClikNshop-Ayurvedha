package com.example.repository;

import java.util.List;

import com.example.model.Shop;

public interface ShopDao {
	    void save(Shop shop);
	    void update(Shop shop);
	    void delete(Long id);
        Shop findById(Long id);
	    List<Shop> findAll();
	    List<Shop> findShopsWithProduct(Long productId);
}
