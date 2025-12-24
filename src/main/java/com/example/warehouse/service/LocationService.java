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
		return locationRepository.save(location);
	}

	public Location findById(Long id) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	public Location saveLocation(Location location) {
		return locationRepository.save(location);
	}
}
