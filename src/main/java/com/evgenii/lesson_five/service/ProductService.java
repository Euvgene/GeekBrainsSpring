package com.evgenii.lesson_five.service;

import com.evgenii.lesson_five.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getProduct();

    void saveOrUpdateCustomer(Product product);

    Product getProduct(Long id);

    void deleteProduct(Long id);

    List<Product> searchProduct(String theSearchTitle);
}
