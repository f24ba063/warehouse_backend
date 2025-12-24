package com.example.warehouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location {
	@Id @GeneratedValue
	private Long warehouseId;
	private String zoneId;
	private String rackId;
	private String shelfId;
	private String locationCode;
	private int maxCapacity;
	private int isVisible = 1;
}