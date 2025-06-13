package com.example.productandinventorymgt.Product_Inventory_Management.exceptionhandler;

public class InventoryNotFoundException extends RuntimeException{

    public InventoryNotFoundException(String message){
        super(message);
    }
}
