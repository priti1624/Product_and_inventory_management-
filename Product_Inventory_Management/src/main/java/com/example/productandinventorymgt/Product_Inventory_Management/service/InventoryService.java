package com.example.productandinventorymgt.Product_Inventory_Management.service;

import com.example.productandinventorymgt.Product_Inventory_Management.dto.InventoryDTO;
import com.example.productandinventorymgt.Product_Inventory_Management.entity.Inventory;
import com.example.productandinventorymgt.Product_Inventory_Management.entity.Product;
import com.example.productandinventorymgt.Product_Inventory_Management.exceptionhandler.InventoryNotFoundException;
import com.example.productandinventorymgt.Product_Inventory_Management.exceptionhandler.ProductNotFoundException;
import com.example.productandinventorymgt.Product_Inventory_Management.repository.InventoryRepository;
import com.example.productandinventorymgt.Product_Inventory_Management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public Inventory addInventory(InventoryDTO dto){
        Product product=productRepository.findById(dto.getProductId())
                .orElseThrow(()->new ProductNotFoundException("Product not found"));
        Inventory inventory=new Inventory();
        inventory.setProduct(product);
        inventory.setAvailableQuantity(dto.getAvailableQuantity());
        inventory.setLastUpdated(LocalDateTime.now());

        return inventoryRepository.save(inventory);
    }

    public Inventory updateQuantity(Long productId,int quantity){
        Inventory inventory= inventoryRepository.findById(productId)
                .orElseThrow(()-> new InventoryNotFoundException("Inventory not found"));
        inventory.setAvailableQuantity(quantity);
        inventory.setLastUpdated(LocalDateTime.now());

        return inventoryRepository.save(inventory);
    }

    public List<Inventory> getAll(){
        return inventoryRepository.findAll();
    }

}
