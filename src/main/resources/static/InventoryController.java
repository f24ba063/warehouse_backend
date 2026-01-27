package com.example.warehouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//実際の在庫を扱うコントローラ
@Controller
public class InventoryController {

	@GetMapping("/inventory")
	public String inventory(){
		return "inventory.html";
	}
}
