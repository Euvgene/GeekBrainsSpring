package com.evgenii.lesson_five.dao;

import com.evgenii.lesson_five.entity.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> getProduct();

    void saveOrUpdateProduct(Product product);

    Product getProduct(Long id);

    void deleteProduct(Long id);

    List<Product> searchProduct(String theSearchTitle);
}
