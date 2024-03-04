package com.example.springbootcrudex.repository;

import com.example.springbootcrudex.Entity.product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface productRepository extends JpaRepository <product,Integer>{
    Optional<product> findByName(String name);
}
