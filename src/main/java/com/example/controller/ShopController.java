package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.ShopResponse;
import com.example.model.Shop;
import com.example.service.ShopService;

@RestController
@RequestMapping("/api/shops")
public class ShopController {

	@Autowired
    private ShopService shopService;

    @GetMapping
    public List<Shop> getAllShops() {
        return shopService.getAllShops();
    }

    @GetMapping("/{id}")
    public Shop getShop(@PathVariable Long id) {
        return shopService.getShopById(id);
    }

    @PostMapping
    public Shop createShop(@RequestBody Shop shop) {
        shopService.saveShop(shop);
        return shop;
    }

    @PutMapping("/{id}")
    public Shop updateShop(@PathVariable Long id, @RequestBody Shop shop) {
        shop.setId(id);
        shopService.updateShop(shop);
        return shop;
    }
    @GetMapping("/nearest")
    public ShopResponse getNearestShop(
            @RequestParam Double userLat,
            @RequestParam Double userLon,
            @RequestParam Long productId) {

        return shopService.findNearestShop(userLat, userLon, productId);
    }

    @DeleteMapping("/{id}")
    public String deleteShop(@PathVariable Long id) {
        shopService.deleteShop(id);
        return "Shop deleted with id: " + id;
    }
}
