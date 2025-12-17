package com.example.warehouse.controller.masterController;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.warehouse.model.Warehouse;
import com.example.warehouse.service.WarehouseService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/master/warehouse")
public class WarehousetMasterController {
	private final WarehouseService warehouseService ;

	public WarehousetMasterController(WarehouseService warehouseService) {
		this.warehouseService = warehouseService;
	}

	@GetMapping
	public List<Warehouse> getAllWarehouses(){
		return warehouseService.getAllWarehouses();
	}
	
	@PostMapping
	public Warehouse addW(@RequestBody Warehouse warehouse) {
		return warehouseService.addWarehouse(warehouse);
	}
	
	@PatchMapping("{id}/softDelete")
	public void softDeleteWarehouset(@PathVariable Long id){
		Warehouse warehouse = warehouseService.findById(id);
		if(warehouse != null) {
			warehouse.setIsVisible(0);
			warehouseService.saveWarehouse(warehouse);
		}
	}
}

