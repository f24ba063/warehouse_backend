package com.example.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.warehouse.model.Partner;

public interface PartnerRepository extends JpaRepository<Partner, Long> {

}
