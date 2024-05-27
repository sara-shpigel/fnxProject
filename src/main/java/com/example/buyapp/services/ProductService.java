package com.example.buyapp.services;

import com.example.buyapp.models.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    private Map<String, Product> products = new HashMap<>();

    public ProductService() {
        // Initialize with some products
        products.put("30min", new Product("30min", "30 minutes", 20));
        products.put("50min", new Product("50min", "50 minutes", 30));
        products.put("100min", new Product("100min", "100 minutes", 50));
        products.put("unlimited", new Product("unlimited", "Unlimited calls", 100));
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    public Product getProductById(String id) {
        return products.get(id);
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }
}
