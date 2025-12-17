package com.example.warehouse.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Invoice {
	@Id @GeneratedValue
	private Long id;
	private String productCode;
	private int quantity;
	private LocalDateTime dateTime;
}
