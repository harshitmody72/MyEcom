package com.streamLiners.models;

public class CartItem {

    String name;
    float unitPrice , qty;

    public CartItem(String name, float unitPrice, float qty) {

        this.name = name;
        this.unitPrice = unitPrice;
        this.qty = qty;
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