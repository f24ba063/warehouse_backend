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

import com.example.warehouse.model.Product;
import com.example.warehouse.service.ProductService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/master/products")
public class ProductMasterController {
	private final ProductService productService;

	public ProductMasterController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@PostMapping
	public Product addP(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	@PatchMapping("{id}/softDelete")
	public void softDeleteProduct(@PathVariable Long id){
		Product product = productService.findById(id);
		if(product != null) {
			product.setIsVisible(0);
			productService.saveProduct(product);
		}
	}
}

