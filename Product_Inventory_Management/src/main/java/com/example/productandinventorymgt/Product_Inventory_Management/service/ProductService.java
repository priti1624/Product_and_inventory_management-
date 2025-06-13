package com.example.productandinventorymgt.Product_Inventory_Management.service;

import com.example.productandinventorymgt.Product_Inventory_Management.dto.ProductDTO;
import com.example.productandinventorymgt.Product_Inventory_Management.entity.Product;
import com.example.productandinventorymgt.Product_Inventory_Management.exceptionhandler.ProductNotFoundException;
import com.example.productandinventorymgt.Product_Inventory_Management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(ProductDTO dto){
        Product product=new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setCategory(dto.getCategory());
        product.setUnit(dto.getUnit());
        return productRepository.save(product);
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product getById(Long id){
        return productRepository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException("Product not found"));
    }

    public void deleteById(Long id){
        if(!productRepository.existsById(id)){
            throw new ProductNotFoundException("Cannot delete: Product not found");
        }
        productRepository.deleteById(id);
    }

    public Product updateProduct(Long id,ProductDTO dto){
        Product product=productRepository.findById(id)
                .orElseThrow(()->new ProductNotFoundException("Product with id"+ id + "not found"));
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setCategory(dto.getCategory());
        product.setUnit(dto.getUnit());

        return productRepository.save(product);
    }
}
