package com.example.backend.service;

import com.example.backend.model.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);

    Product update(Product product);

    Product findById(Long id);

    List<Product> findAll();
}
