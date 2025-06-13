package com.example.productandinventorymgt.Product_Inventory_Management.exceptionhandler;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String message){
        super(message);
    }
}
