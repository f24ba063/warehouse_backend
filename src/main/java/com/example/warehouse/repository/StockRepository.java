package com.example.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.warehouse.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {

}
