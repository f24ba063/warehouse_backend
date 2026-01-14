package com.example.warehouse.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "APP_USER")
@Data
public class AppUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "USERNAME", nullable = false, unique = true)
	private String username;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@Column(name = "ROLE", nullable = false)
	private String role;
	
	@Column(name = "ENABLED", nullable = false)
	private Boolean enabled;
	
	public boolean isEnabled() {
		return enabled;
	}
}
