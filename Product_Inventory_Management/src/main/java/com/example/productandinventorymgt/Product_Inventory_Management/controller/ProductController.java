package com.example.productandinventorymgt.Product_Inventory_Management.controller;

import com.example.productandinventorymgt.Product_Inventory_Management.dto.ProductDTO;
import com.example.productandinventorymgt.Product_Inventory_Management.entity.Product;
import com.example.productandinventorymgt.Product_Inventory_Management.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> addProduct(@Valid @RequestBody ProductDTO dto){
        Product saved=productService.addProduct(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id){
        Product product=productService.getById(id);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteById(@PathVariable Long id){
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id, @Valid @RequestBody ProductDTO dto){
        Product updated=productService.updateProduct(id,dto);
        return ResponseEntity.ok(updated);
    }

}
