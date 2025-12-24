package com.example.warehouse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.warehouse.model.Partner;
import com.example.warehouse.repository.PartnerRepository;

@Service
public class PartnerService {
	private final PartnerRepository partnerRepository;

	
	public PartnerService(PartnerRepository partnerRepository) {
		this.partnerRepository = partnerRepository;
	}

	public List<Partner> getAllPartners(){
		return partnerRepository.findAll();
	}
	
	public Partner addPartner(Partner partner) {
		return partnerRepository.save(partner);
	}

	public Partner findById(Long id) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	public Partner savePartner(Partner partner) {
		return partnerRepository.save(partner);
	}
}
