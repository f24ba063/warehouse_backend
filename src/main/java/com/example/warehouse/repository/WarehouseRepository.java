package com.example.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.warehouse.model.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

}
