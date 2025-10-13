package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTO.ShopResponse;
import com.example.model.Shop;
import com.example.repository.ShopDao;

@Service
public class ShopServiceiImpl implements ShopService {


    @Autowired
    private ShopDao shopDao;

    @Override
    public Shop getShopById(Long id) {
        return shopDao.findById(id);
    }

    @Override
    public List<Shop> getAllShops() {
        return shopDao.findAll();
    }

    @Override
    public void saveShop(Shop shop) {
        shopDao.save(shop);
    }

    @Override
    public void updateShop(Shop shop) {
        shopDao.update(shop);
    }

    @Override
    public void deleteShop(Long id) {
        shopDao.delete(id);
    }

    @Override
    public ShopResponse findNearestShop(Double userLat, Double userLon, Long productId) {
        List<Shop> shopsWithProduct = shopDao.findShopsWithProduct(productId);

        Shop nearestShop = null;
        double minDistance = Double.MAX_VALUE;

        for (Shop shop : shopsWithProduct) {
            double distance = calculateDistance(userLat, userLon, shop.getLatitude(), shop.getLongitude());
            if (distance < minDistance) {
                minDistance = distance;
                nearestShop = shop;
            }
        }

        if (nearestShop == null) {
            return null;
        }

        ShopResponse response = new ShopResponse();
        response.setId(nearestShop.getId());
        response.setName(nearestShop.getName());
        response.setCity(nearestShop.getCity());
        response.setLatitude(nearestShop.getLatitude());
        response.setLongitude(nearestShop.getLongitude());
        response.setOpen(nearestShop.getIsOpen());
        response.setDistanceInKm(minDistance);

        return response;
    }

    //  (Haversine formula)
    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radius of Earth in km
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}
