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

import com.example.warehouse.model.Partner;
import com.example.warehouse.service.PartnerService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/master/partner")
public class PartnerMasterController {
	private final PartnerService partnerService ;

	public PartnerMasterController(PartnerService partnerService) {
		this.partnerService = partnerService;
	}

	@GetMapping
	public List<Partner> getAllPartner(){
		return partnerService.getAllPartners();
	}
	
	@PostMapping
	public Partner addW(@RequestBody Partner partner) {
		return partnerService.addPartner(partner);
	}
	
	@PatchMapping("{id}/softDelete")
	public void softDeleteWarehouset(@PathVariable Long id){
		Partner partner = partnerService.findById(id);
		if(partner != null) {
			partner.setIsVisible(0);
			partnerService.savePartner(partner);
		}
	}
}

