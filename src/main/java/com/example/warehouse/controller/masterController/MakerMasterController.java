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

import com.example.warehouse.model.Maker;
import com.example.warehouse.service.MakerService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/master/maker")
public class MakerMasterController {
	private final MakerService makerService ;

	public MakerMasterController(MakerService makerService) {
		this.makerService = makerService;
	}

	@GetMapping
	public List<Maker> getAllMakers(){
		return makerService.getAllMaker();
	}
	
	@PostMapping
	public Maker addW(@RequestBody Maker maker) {
		return makerService.addMaker(maker);
	}
	
	@PatchMapping("{id}/softDelete")
	public void softDeleteWarehouset(@PathVariable Long id){
		Maker maker = makerService.findById(id);
		if(maker != null) {
			maker.setIsVisible(0);
			makerService.saveMaker(maker);
		}
	}
}