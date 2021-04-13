package com.streamLiners;

import com.streamLiners.models.Product;
import com.streamLiners.models.Variant;
import com.streamLiners.models.VariantsBasedProduct;
import com.streamLiners.models.WeightBasedProduct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        //Create Product
        Product apple =  new WeightBasedProduct( "Apple"," ",1,100);
        Product kiwi = new VariantsBasedProduct("kiwi"," ",new ArrayList<>(
                Arrays.asList(
                        new Variant("500g",80),
                        new Variant("1kg",160)

                )
        ));

        //Add them in a list
        List<Product> products = new ArrayList<>(
                Arrays.asList(apple,kiwi)
        );
        //Print the List
        System.out.println(products);
    }
}
