package com.example.productandinventorymgt.Product_Inventory_Management.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InventoryDTO {


    @NotNull(message = "Product ID is required")
    @Min(value = 1, message = "Product ID must be greater than 0")
    private Long ProductId;

    @NotNull(message = "Quantity is required")
    @Min(value = 0, message = "Quantity cannot be negative")
    private int availableQuantity;

    private LocalDateTime lastUpdated;
    public InventoryDTO() {
    }

    public InventoryDTO(Long productId, int availableQuantity, LocalDateTime lastUpdated) {
        ProductId = productId;
        this.availableQuantity = availableQuantity;
        this.lastUpdated=lastUpdated;
    }

    public @NotNull Long getProductId() {
        return ProductId;
    }

    public void setProductId(@NotNull Long productId) {
        ProductId = productId;
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
}
