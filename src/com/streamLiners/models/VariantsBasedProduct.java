package com.streamLiners.models;

import java.util.List;

public class VariantsBasedProduct extends Product{
    List<Variant> variants;

    public VariantsBasedProduct(String name, String imageURL , List<Variant> variants) {
        super(name, imageURL);
        this.variants = variants;
    }

    @Override
    public String toString() {
        return "VariantsBasedProduct{" +
                "name='" + name + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", variants=" + variants +
                '}';
    }
}
