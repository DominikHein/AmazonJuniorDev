package com.coffeeshop.menu.service;

import com.coffeeshop.menu.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    void saveProduct(Product product);
    // TODO 1: write a method in the ProductService interface to get the Product object from the database.
    Product getProductById(int id);

    // TODO 19: Add the method for delete
    void deleteProductById(int id);
}
