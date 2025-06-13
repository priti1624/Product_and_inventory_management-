package com.example.productandinventorymgt.Product_Inventory_Management.repository;

import com.example.productandinventorymgt.Product_Inventory_Management.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {
}
