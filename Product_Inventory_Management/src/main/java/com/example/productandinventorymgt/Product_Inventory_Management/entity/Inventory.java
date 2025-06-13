package com.example.productandinventorymgt.Product_Inventory_Management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Product Id is required")
    private Long productId;

    @NotNull(message = "Quantity is required")
    @Min(0)
    private int availableQuantity;

    private LocalDateTime lastUpdated;

    @OneToOne
    @MapsId
    @JoinColumn(name = "product_id")
    private Product product;

    public Inventory() {
    }

    public Inventory(Long productId, int availableQuantity, LocalDateTime lastUpdated, Product product) {
        this.productId = productId;
        this.availableQuantity = availableQuantity;
        this.lastUpdated = lastUpdated;
        this.product = product;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Min(0)
    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(@Min(0) int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
