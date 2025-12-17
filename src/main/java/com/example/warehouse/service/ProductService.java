package com.example.warehouse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.warehouse.model.Product;
import com.example.warehouse.repository.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;

	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product findById(Long id){
		return productRepository.findById(id).orElse(null);
	}
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
}
