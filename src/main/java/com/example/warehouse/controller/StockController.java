package com.example.warehouse.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.warehouse.model.Stock;
import com.example.warehouse.repository.StockRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/stock")
@RequiredArgsConstructor
public class StockController {

	private final StockRepository stockR;
	
	public List<Stock> getStock(){
		return stockR.findAll();
	}
}
