package com.example.productandinventorymgt.Product_Inventory_Management.controller;

import com.example.productandinventorymgt.Product_Inventory_Management.dto.InventoryDTO;
import com.example.productandinventorymgt.Product_Inventory_Management.entity.Inventory;
import com.example.productandinventorymgt.Product_Inventory_Management.service.InventoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    //Add inventory
    @PostMapping
    public ResponseEntity<Inventory> addInventory(

            @Valid @RequestBody InventoryDTO dto){
        Inventory inventory =inventoryService.addInventory(dto);
        return ResponseEntity.ok(inventory);

    }

    //update quantity
    @PutMapping("/{productId}")
    public ResponseEntity<Inventory> updateQuantity(
           @PathVariable Long productId,@RequestParam int newQuantity){
        Inventory inventory=inventoryService.updateQuantity(productId,newQuantity);
        return ResponseEntity.ok(inventory);
    }

    //view all inventory
    @GetMapping
    public ResponseEntity<List<Inventory>> getAllInventory(){
        List<Inventory> inventoryList=inventoryService.getAll();
        return ResponseEntity.ok(inventoryList);
    }



}
