package com.example.warehouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="MAKER_MASTER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Maker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long makerId;
	
	private String makerType;
	private String makerName;
	private String address;
	private String access;
	
	private int isVisible = 1;

}