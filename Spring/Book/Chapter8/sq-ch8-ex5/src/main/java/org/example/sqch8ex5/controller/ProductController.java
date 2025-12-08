package org.example.sqch8ex5.controller;

import org.example.sqch8ex5.model.Product;
import org.example.sqch8ex5.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String viewProducts(Model model){
        var products = productService.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }

    @PostMapping(path = "/products")
    public String addProduct(
            @RequestParam String name,
            @RequestParam double price,
            Model model){
            Product p = new Product();
            p.setName(name);
            p.setPrice(price);
            productService.addProduct(p);

            var  products = productService.findAll();
            model.addAttribute("products", products);

    return "products.html";
    }
}

