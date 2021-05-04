package com.streamLiners.models;

import java.util.HashMap;

public class Cart {

    public HashMap<String, CartItem> cartItems = new HashMap<>();
    public float total, noOfItems;

    //adding WBP
    public void add(Product product, float qty) {

        //If item already exists in cart
        if (cartItems.containsKey(product.name)) {
            total -= cartItems.get(product.name).cost();
            cartItems.get(product.name).qty = qty;
        }

        //Adding for the first time
        else {
            CartItem item = new CartItem(product,product.name, product.pricePerKg, qty);
            cartItems.put(product.name, item);
            noOfItems++;
        }

        //Update cart summary
        total += product.pricePerKg * qty;


    }

    //adding VBP
    public void add(Product product, Variant variant) {

        String key = product.name + " " + variant.name;

        //Already exists
        if (cartItems.containsKey(key)) {
            cartItems.get(key).qty++;
        }

        //Add for the first time
        else{
            CartItem item = new CartItem(product,product.name, variant.price, 1);
            cartItems.put(key,item);
        }
        //Update cart summary
        noOfItems++;
        total += variant.price;

    }

    //removing product
    public void remove(Product product) {
        if(product.type == ProductType.TYPE_WB) {
            //Update cartSummary
            total -= cartItems.get(product.name).cost();
            noOfItems--;
            cartItems.remove(product.name);
        }
        else {
            removeAllVariantOfVBP(product);

        }


    }

    //removing VBP
    public void removeAllVariantOfVBP(Product product){
        for(Variant variant : product.variants) {
            String key = product.name + " " + variant.name;


            if (cartItems.containsKey(key)) {
                //Update cartSummary
                total -= cartItems.get(key).cost();
                noOfItems -= 1;

                cartItems.remove(key);
            }
        }

    }

    //decrement qty
    public void decrement(Product product, Variant variant){
        String key = product.name + " " + variant.name;

        //Update qty
        cartItems.get(key).qty--;

        //Update cartSummary
        total -= variant.price;
        noOfItems --;

        //Remove if qty = 0
        if(cartItems.get(key).qty== 0)
            cartItems.remove(key);

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        int count=1;
        for (CartItem cartItem:cartItems.values()){
            stringBuilder.append("\n").append(count).append(")").append(cartItem);
            count++;
        }
        return "MyCart :-" +
                "  "+ stringBuilder +
                String.format("\ntotal %.0f items (Rs. %.2f)", noOfItems, total);
    }
}