package com.quickcart.ecommerce.controller;

import org.springframework.ui.Model;
import com.quickcart.ecommerce.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

//TODO 5: create a public method named getProducts that accepts a Model object as argument and returns a String representing the view name
// TODO 5a: add the @GetMapping annotation with the value "/products" to map the method to the URL "/products"

@Controller

public class ProductController {
    @GetMapping({"/", "/products"})
    public String getProducts(Model productModel) {
        // TODO 6: declare a List of Product objects and initialize it with an empty ArrayList
        List<Product> products = new ArrayList<>();

        // TODO 7: create three new Product objects, namely, Laptop, Smartphone, and Headphones with details
        Product laptop = new Product(1, "Laptop", "A laptop for work and play", 500.0);
        Product smartphone = new Product(2, "Smartphone", "A generic Smartphone", 400.0);
        Product headphones = new Product(3, "Headphones", "Good Over-Ear Headphones", 300.0);
        // Create two more...

        // TODO 8: add the three Product objects to the List of products
        products.add(laptop);
        products.add(smartphone);
        products.add(headphones);
        // Add the rest...

        // TODO 9: add the List of products to the Model object with the key "products"
        productModel.addAttribute("products", products);

        // TODO 10: return the view name "products" as a String
        return "products";

    }

}
