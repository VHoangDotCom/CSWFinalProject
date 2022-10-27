package com.finalexam.service;

import com.finalexam.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(Long id);

    boolean deleteProduct(Long id);

    Product sellProduct(Long id, Product product);
}
