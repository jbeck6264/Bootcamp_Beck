package org.example;

import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<Product> cartItems = new ArrayList<>();

    //Add a product
    public void addProduct(Product product) {
        cartItems.add(product);
        System.out.println("Product added to cart!");
    }
// Display
    public void displayCart(){

        System.out.println("\n----- YOUR CART -----");

        double total = 0;
        if (cartItems.size() == 0){
            System.out.println("Your cart is empty.");
        }
        else {
            for (int i = 0; i < cartItems.size(); i++){
                Product product = cartItems.get(i);

                product.displayProduct();

                total = total + product.getPrice();
            }
            System.out.printf("Cart Total: $%.2f%n", total);
        }
    }
    public void removeProduct(String sku){

        boolean found = false;

        for(int i = 0; i <cartItems.size(); i++){

            Product product = cartItems.get(i);

            if(product.getSku().equalsIgnoreCase(sku)){

                cartItems.remove(i);
                found = true;

                System.out.println("Product removed!");
                break;
            }
        }
        if (found == false){
            System.out.println("Product not found in your cart.");
        }
    }
}