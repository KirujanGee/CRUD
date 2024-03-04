package com.example.springbootcrudex.controller;

import com.example.springbootcrudex.Entity.product;
import com.example.springbootcrudex.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class productController {

    @Autowired
    private productService service;
@PostMapping("/addProduct")
    public product addProduct(@RequestBody product Product){
        return service.saveProduct(Product);
    }
@PostMapping("/addProducts")
    public List<product> addProducts(@RequestBody List<product> Products){
        return service.saveProducts(Products);
    }
@GetMapping("/products")
    public List<product> findAllProducts(){
    return service.getProducts();
    }
@GetMapping("/productById/{id}")
    public Optional<product> findProductById(@PathVariable int id){
    return service.getProductById(id);
    }
@GetMapping("/products/{name}")
    public Optional<product> findProductByName(@PathVariable String name){
        return service.getProductByName(name);
    }

    @PutMapping("/update")
    public product updateProduct(@RequestBody product Product){
        return service.updateProduct(Product);
    }
@DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
    return service.deleteProduct(id);
    }

}
