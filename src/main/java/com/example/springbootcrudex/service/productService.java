package com.example.springbootcrudex.service;


import com.example.springbootcrudex.Entity.product;
import com.example.springbootcrudex.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class productService {
    @Autowired
    private productRepository repository;

    public product saveProduct(product Product){
        return repository.save(Product);
    }
    public List<product> saveProducts(List<product> Products){
        return repository.saveAll(Products);
    }

    public List<product> getProducts(){
        return repository.findAll();

    }
    public Optional<product> getProductById(int id){
        return repository.findById(id);

    }
    public Optional<product> getProductByName(String name ){
        return repository.findByName(name);

    }
    public String deleteProduct(int id){
         repository.deleteById(id);
         return ("product removed !"+ id);
    }

    public product updateProduct(product updatedProduct){

        Optional<product> OptionalExistingProduct = repository.findById(updatedProduct.getId());
        if(OptionalExistingProduct != null) {
            product existingProduct = OptionalExistingProduct.get();
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setQuantity(updatedProduct.getQuantity());
            existingProduct.setPrice(updatedProduct.getPrice());

            return repository.save(existingProduct);
        }else{
            return null;
        }
    }

}
