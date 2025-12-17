package com.example.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.warehouse.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
