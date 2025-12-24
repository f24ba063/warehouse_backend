package com.example.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.warehouse.model.Maker;

public interface MakerRepository extends JpaRepository<Maker, Long> {

}
