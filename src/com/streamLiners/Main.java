package com.streamLiners;

import com.streamLiners.models.Cart;
import com.streamLiners.models.CartItem;
import com.streamLiners.models.Product;
import com.streamLiners.models.Variant;
import com.streamLiners.models.ProductType;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Main {

    static Product apple = new Product("Apple", " ", 0.5f, 100),
            kiwi = new Product("kiwi", " ", new ArrayList<>(
                    Arrays.asList(
                            new Variant("500g", 96)
                            , new Variant("1kg", 180)
                    )
            ));

    public static void main(String[] args) {

        list();
        Cart cart = new Cart();
        while (true) {

            Scanner sc = new Scanner(System.in);
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    addWBProduct(apple, sc, cart);
                    break;
                case 2:
                    addVBProduct(cart, sc, kiwi);
                    break;
                case 3:
                    while (true) {
                        System.out.println(cart);
                        if (cart.total == 0f) {
                            System.out.println("Cart is Empty\n");
                            break;
                        }
                        System.out.println("0)Go back");
                        System.out.println("1)To select the item ");
                        int opt = sc.nextInt();
                        if (opt == 0) {
                            break;
                        } else {
                            System.out.println("Select which item you want to edit or remove:-");
                            editMyCart(cart, sc);
                        }
                    }
                    break;
                case 4:
                    return;

            }
            list();
        }

    }

    private static void editMyCart(Cart cart, Scanner sc) {
        int selectItem = sc.nextInt();
        int count = 1;
        for (CartItem cartItem : cart.cartItems.values()) {
            if (count++ == selectItem) {
                if (cartItem.product.type == ProductType.TYPE_WB) {
                    String str = "0)To remove the item\n" +
                            "1)To edit the item";
                    System.out.println(str);
                    int option = sc.nextInt();
                    switch (option) {
                        case 0:
                            cart.remove(cartItem.product);
                            System.out.println("Product is successfully remove ");
                            return;

                        case 1:
                            addWBProduct(cartItem.product, sc, cart);
                            return;
                    }
                } else {
                    String str = "0)To remove the item completely\n" +
                            "1)To edit the item";
                    System.out.println(str);

                    int option = sc.nextInt();
                    switch (option) {
                        case 0:
                            cart.remove(cartItem.product);
                            System.out.println("Product is successfully remove ");
                            return;

                        case 1:
                            System.out.println("Variants are" + cartItem.product);
                            System.out.println("Enter which variant you want to edit ");
                            int variant = sc.nextInt();
                            System.out.println("1)To add single quantity of  variant \n2)To decrease only single quantity of variant");
                            int options = sc.nextInt();

                            if (options == 1) {
                                cart.add(cartItem.product, cartItem.product.variants.get(variant - 1));
                            } else if (options == 2) {
                                try {
                                    cart.decrement(cartItem.product, cartItem.product.variants.get(variant - 1));
                                    System.out.println("Product is successfully edited");
                                } catch (Exception e) {
                                    System.out.println("Variant is already remove from the cart");
                                }
                            }
                            return;
                    }
                }
            }
        }
    }

    //Adding VB Product
    private static void addVBProduct(Cart cart, Scanner sc, Product product) {
        System.out.println("Enter which variant you want to add" + product);
        int variant = sc.nextInt();
        cart.add(product, product.variants.get(variant - 1));
        System.out.println("Product Added");

    }

    //Adding WB Product
    private static void addWBProduct(Product product, Scanner sc, Cart cart) {
        System.out.println("Enter the quantity of product");
        int qty = sc.nextInt();
        cart.add(product, qty);
        System.out.println("Product Added");
    }

    private static void list() {

        String str = "The list of products:-\n" +
                "1) To add Apple (" + apple + ")\n" +
                "2) To add Kiwi( Variants are" + kiwi + ")\n" +
                "3) Show my cart\n" +
                "4) Do you want to Exit\n\n" +
                " Choose any option :-";
        System.out.println(str);
    }

}

