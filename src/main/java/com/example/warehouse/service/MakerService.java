package com.example.warehouse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.warehouse.model.Maker;
import com.example.warehouse.repository.MakerRepository;

@Service
public class MakerService {
	private final MakerRepository makerRepository;

	
	public MakerService(MakerRepository makerRepository) {
		this.makerRepository = makerRepository;
	}

	public List<Maker> getAllMaker(){
		return makerRepository.findAll();
	}
	
	public Maker addMaker(Maker maker) {
		return makerRepository.save(maker);
	}

	public Maker findById(Long id) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	public Maker saveMaker(Maker maker) {
		return makerRepository.save(maker);
	}
}
