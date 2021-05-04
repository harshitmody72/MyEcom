package com.streamLiners.models;

public class CartItem {

    String name;
    float unitPrice , qty;
    public Product product;

    public CartItem(Product product, String name, float qty, float unitPrice) {
        this.product = product;
        this.name = name;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    float cost(){
        return unitPrice * qty;
    }

    @Override
    public String toString() {
        return "\n" + name + '\'' +
                String.format(", ( %f X %f = %f",unitPrice,qty,cost())
                +" ) ";
    }
}