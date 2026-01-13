package com.example.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.warehouse.model.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long>{
	boolean existsByUsername(String username);
}
