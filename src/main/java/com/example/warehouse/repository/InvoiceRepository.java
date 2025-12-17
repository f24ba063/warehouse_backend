package com.example.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.warehouse.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}