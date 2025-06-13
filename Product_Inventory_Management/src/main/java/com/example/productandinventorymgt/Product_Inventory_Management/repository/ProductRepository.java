package com.example.productandinventorymgt.Product_Inventory_Management.repository;

import com.example.productandinventorymgt.Product_Inventory_Management.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
