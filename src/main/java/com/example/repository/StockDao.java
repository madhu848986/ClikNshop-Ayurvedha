package com.example.repository;

import java.util.List;

import com.example.model.Stock;

public interface StockDao {
	   int save(Stock stock);
	    int updateStock(Long shopId, Long productId, int quantity);
	    List<Stock> findByShop(Long shopId);
}
