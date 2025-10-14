package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Product;
import com.example.repository.ProductDao;

@Service
public class ProdutServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product addProduct(Product product) {
        productDao.save(product);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productDao.findById(id);
    }

    // Update product
    @Override
    public Product updateProduct(Long id, Product product) {
        Product existing = getProductById(id);
        if (existing != null) {
            existing.setName(product.getName());
            existing.setDescription(product.getDescription());
            existing.setPrice(product.getPrice());
            existing.setCategory(product.getCategory());
            existing.setExpiry_date(product.getExpiry_date());
            existing.setImage_url(product.getImage_url());
            productDao.update(existing);
            return existing;
        }
        return null;
    }

    // Delete product
    @Override
    public boolean deleteProduct(Long id) {
        Product existing = getProductById(id);
        if (existing != null) {
            productDao.deleteById(id);
            return true;
        }
        return false;
    }
}
