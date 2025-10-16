package com.example.service;

import java.util.List;

import com.example.DTO.ShopResponse;

import com.example.model.Shop;

public interface ShopService {
	

    Shop getShopById(Long id);

    List<Shop> getAllShops();

    void saveShop(Shop shop);

    void updateShop(Shop shop);

    void deleteShop(Long id);

    ShopResponse findNearestShop(Double userLat, Double userLon, Long productId);
}
