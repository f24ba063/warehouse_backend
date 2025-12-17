package com.example.warehouse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.warehouse.model.Warehouse;
import com.example.warehouse.repository.WarehouseRepository;

@Service
public class WarehouseService {
	private final WarehouseRepository warehouseRepository;

	
	public WarehouseService(WarehouseRepository warehouseRepository) {
		this.warehouseRepository = warehouseRepository;
	}

	public List<Warehouse> getAllWarehouses(){
		return warehouseRepository.findAll();
	}
	
	public Warehouse addWarehouse(Warehouse warehouse) {
		return warehouseRepository.save(warehouse);
	}

	public Warehouse findById(Long id) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	public Warehouse saveWarehouse(Warehouse warehouse) {
		return warehouseRepository.save(warehouse);
	}
}
