package com.example.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.warehouse.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

}