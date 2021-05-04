package com.streamLiners.models;

import java.util.List;
import java.util.Objects;

public class Product {

    //Common
    public String name, imageURL;
    public int type;

    //WBP(WeightBasedProduct)
    float minQty, pricePerKg;

    //VBP(VariantsBasedProduct)
    public List<Variant> variants;

    //WB
    public Product(String name, String imageURL, float minQty, float pricePerKg) {
        type = ProductType.TYPE_WB;
        this.name = name;
        this.imageURL = imageURL;
        this.minQty = minQty;
        this.pricePerKg = pricePerKg;
    }

    //VB
    public Product(String name, String imageURL, List<Variant> variants) {
        type = ProductType.TYPE_VB;

        this.name = name;
        this.imageURL = imageURL;
        this.variants = variants;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if(type == ProductType.TYPE_WB)
            builder.append("WB { ");
        else
            builder.append("VB { ");

        builder.append("name = ").append(name);

        if(type == ProductType.TYPE_WB){
            builder.append(", minQty = ").append(minQty);
            builder.append(", pricePerKg = ").append(pricePerKg);
        }
        else {
            builder.append("VB { ");
            builder.append(", variants = ").append(variants);
        }
        builder.append(" } ");

        return builder.toString();
    }
}