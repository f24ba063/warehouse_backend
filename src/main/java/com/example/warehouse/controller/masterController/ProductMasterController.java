package com.example.warehouse.controller.masterController;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    // 全件取得
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // 新規登録
    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        if (productService.existsByProductName(product.getProductName())) {
            return ResponseEntity
                    .badRequest()
                    .body("この商品はすでに存在しています。");
        }

        Product saved = productService.saveProduct(product);
        return ResponseEntity.ok(saved);
    }

    // 更新
    @PutMapping("{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product existing = productService.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        Product updated = productService.updateProduct(id, product);
        return ResponseEntity.ok(updated);
    }

    // ソフトデリート
    @PatchMapping("{id}/softDelete")
    public ResponseEntity<?> softDeleteProduct(@PathVariable Long id) {
        Product existing = productService.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        productService.softDelete(id);
        return ResponseEntity.ok().build();
    }
}