package com.example.productandinventorymgt.Product_Inventory_Management.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductDTO {

    @NotBlank
    private String name;

    private String description;

    @Min(0)
    private double price;

    @NotBlank
    private String category;

    @NotBlank
    private String unit;

    public ProductDTO() {
    }

    public ProductDTO(String name, String description, double price, String category, String unit) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.unit = unit;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Min(0)
    public double getPrice() {
        return price;
    }

    public void setPrice(@Min(0) double price) {
        this.price = price;
    }

    public @NotBlank String getCategory() {
        return category;
    }

    public void setCategory(@NotBlank String category) {
        this.category = category;
    }

    public @NotBlank String getUnit() {
        return unit;
    }

    public void setUnit(@NotBlank String unit) {
        this.unit = unit;
    }
}
