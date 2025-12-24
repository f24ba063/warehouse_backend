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

import com.example.warehouse.model.Location;
import com.example.warehouse.service.LocationService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/master/location")
public class LocationMasterController {
	private final LocationService locationService ;

	public LocationMasterController(LocationService locationService) {
		this.locationService = locationService;
	}

	@GetMapping
	public List<Location> getAllLocations(){
		return locationService.getAllLocations();
	}
	
	@PostMapping
	public Location addW(@RequestBody Location location) {
		return locationService.addLocation(location);
	}
	
	@PatchMapping("{id}/softDelete")
	public void softDeleteWarehouset(@PathVariable Long id){
		Location location = locationService.findById(id);
		if(location != null) {
			location.setIsVisible(0);
			locationService.saveLocation(location);
		}
	}
}
