package com.example.warehouse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.warehouse.model.Product;
import com.example.warehouse.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 全件取得
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 商品名の存在確認
    public boolean existsByProductName(String productName) {
        return productRepository.existsByProductName(productName);
    }

    // 新規登録
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // IDで取得
    public Product findById(Long id) {
        Optional<Product> optional = productRepository.findById(id);
        return optional.orElse(null);
    }

    // 更新
    public Product updateProduct(Long id, Product updatedProduct) {
        Product existing = findById(id);
        if (existing == null) return null;

        existing.setProductName(updatedProduct.getProductName());
        existing.setMakerName(updatedProduct.getMakerName());
        existing.setCategory(updatedProduct.getCategory());
        existing.setUnitOfMeasure(updatedProduct.getUnitOfMeasure());
        existing.setSafetyStock(updatedProduct.getSafetyStock());
        existing.setOrderQty(updatedProduct.getOrderQty());
        existing.setMinOrderQty(updatedProduct.getMinOrderQty());
        existing.setPackageQty(updatedProduct.getPackageQty());
        existing.setPalletQty(updatedProduct.getPalletQty());
        existing.setIsLotManaged(updatedProduct.getIsLotManaged());
        existing.setIsActive(updatedProduct.getIsActive());
        existing.setIsVisible(updatedProduct.getIsVisible());

        return productRepository.save(existing);
    }

    // ソフトデリート
    public void softDelete(Long id) {
        Product existing = findById(id);
        if (existing != null) {
            existing.setIsVisible(0);
            productRepository.save(existing);
        }
    }
}