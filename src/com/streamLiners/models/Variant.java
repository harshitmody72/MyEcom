package com.streamLiners.models;

public class Variant {
    String name;
    float price;

    public Variant(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s @ Rs. %f",name,price);
    }
}
