package com.example.warehouse.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.warehouse.repository.ProductRepository;
import com.example.warehouse.repository.StockRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner{
	private final ProductRepository productRepo;
	private final StockRepository stockRepo;
	
	@Override
	public void run(String... args) throws Exception{

	}
}
