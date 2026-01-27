package com.example.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.warehouse.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
