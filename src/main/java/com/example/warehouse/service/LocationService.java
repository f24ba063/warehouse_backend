package com.example.warehouse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.warehouse.model.Location;
import com.example.warehouse.repository.LocationRepository;

@Service
public class LocationService {
	private final LocationRepository locationRepository;

	
	public LocationService(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

	public List<Location> getAllLocations(){
		return locationRepository.findAll();
	}
	
    public Location addLocation(Location location) {
        // locationCode自動生成
        String code = String.format("LOC_%d%s%s%s",
                location.getWarehouseId(),
                location.getZoneId(),
                location.getRackId(),
                location.getShelfId());
        location.setLocationCode(code);

        return locationRepository.save(location);
    }


    public Location findByLocationCode(String locationCode) {
        return locationRepository.findById(locationCode).orElse(null);
    }
    
	public Location saveLocation(Location location) {
		return locationRepository.save(location);
	}
}
