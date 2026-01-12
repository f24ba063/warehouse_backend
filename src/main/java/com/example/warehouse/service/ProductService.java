package com.example.warehouse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.warehouse.dto.ProductRequest;
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
	
	public Product findById(Long id){
		return productRepository.findById(id).orElse(null);
	}
	
	public boolean existsByProductName(String name) {
		return productRepository.existsByProductName(name);
	}
	
	public Product createProduct(ProductRequest req) {
		Product p = new Product();
		mapRequestToEntity(req, p);
		return productRepository.save(p);
	}
	
	public Product updateProduct(Long id, ProductRequest req) {
		Product p = findById(id);
		if(p != null) {
			mapRequestToEntity(req, p);
			return productRepository.save(p);
		}
			return null;
	}
	
	public void softDelete(Long id) {
		Product p = findById(id);
		if(p != null) {
			p.setIsVisible(0);
			productRepository.save(p);
		}
	}
	
    private void mapRequestToEntity(ProductRequest req, Product p) {
        p.setProductName(req.getProductName());
        p.setMakerName(req.getMakerName());
        p.setUnitOfMeasure(req.getUnitOfMeasure());
        p.setCategory(req.getCategory());
        p.setSafetyStock(req.getSafetyStock());
        p.setMinOrderQty(req.getMinOrderQty());
        p.setLotManaged(req.isLotManaged());
        p.setActive(req.isActive());
    }
}
