package com.example.warehouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

//在庫を管理するエンティティ
@Entity
@Getter
@Setter
public class Inventory {
	@Id @GeneratedValue
	private Long id;
	private String productCode;
	private int quantity;
}
