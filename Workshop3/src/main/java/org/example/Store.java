package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    private ArrayList<Product> products = new ArrayList<>();
    private ShoppingCart cart = new ShoppingCart();

    public void loadProducts() {

        try {
            BufferedReader reader =
                    new BufferedReader(new FileReader("src/main/resources/products.csv"));

            String line;

            //skip first line
            reader.readLine();

            //Readeach product from the file
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("\\|");

                String sku = parts[0];
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                String departments = parts[3];

                Product product = new Product(sku, name, price, departments);

                products.add(product);
            }
            reader.close();

            System.out.println("Products loaded! ");
        } catch (IOException ex) {

        } catch (Exception e) {
            System.out.println("Error reading products.csv");

        }
    }

    public void displayProduct() {

        System.out.println("\n----- STORE PRODUCTS -----");
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            product.displayProduct();




        }

    }
    public  void addProductToCart(Scanner scanner){
        displayProduct();

        System.out.println("Enter the SKU of the product to add: ");

        String sku = scanner.nextLine();

        boolean found = false;

        for(int i = 0; i < products.size(); i++) {

            Product product = products.get(i);

            if(product.getSku().equalsIgnoreCase(sku)){

                cart.addProduct(product);
                found = true;
                break;
            }
        }
        if(found ==false){
            System.out.println("Product not found.");
        }
    }
    public void searchProducts(Scanner scanner) {

        System.out.println("\n----- SEARCH PRODUCTS -----");
        System.out.println("1. Search by Product Name");
        System.out.println("2. Search by Price Range");
        System.out.println("3. Search by Department");
        System.out.print("Choose an option: ");

        int searchChoice = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;

        if (searchChoice == 1) {

            System.out.print("Enter product name: ");
            String name = scanner.nextLine();

            for (int i = 0; i < products.size(); i++) {

                Product product = products.get(i);

                if (product.getProductName().toLowerCase()
                        .contains(name.toLowerCase())) {

                    product.displayProduct();
                    found = true;
                }
            }

        } else if (searchChoice == 2) {

            System.out.print("Enter minimum price: ");
            double minimum = scanner.nextDouble();

            System.out.print("Enter maximum price: ");
            double maximum = scanner.nextDouble();
            scanner.nextLine();

            for (int i = 0; i < products.size(); i++) {

                Product product = products.get(i);

                if (product.getPrice() >= minimum &&
                        product.getPrice() <= maximum) {

                    product.displayProduct();
                    found = true;
                }
            }

        } else if (searchChoice == 3) {

            System.out.print("Enter department: ");
            String department = scanner.nextLine();

            for (int i = 0; i < products.size(); i++) {

                Product product = products.get(i);

                if (product.getDepartment().equalsIgnoreCase(department)) {

                    product.displayProduct();
                    found = true;
                }
            }

        } else {

            System.out.println("Invalid search option.");
            return;
        }

        if (found == false) {
            System.out.println("No products found.");
        }
    }
    public void productScreen(Scanner scanner) {

        int choice = 0;

        while (choice != 3) {

            System.out.println("\n----- PRODUCTS MENU -----");
            System.out.println("1. Display All Products");
            System.out.println("2. Search Products");
            System.out.println("3. Go Back");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {

                displayProduct();

                System.out.println("\nWould you like to add a product?");
                System.out.println("1. Yes");
                System.out.println("2. No");

                int addChoice = scanner.nextInt();
                scanner.nextLine();

                if (addChoice == 1) {
                    addProductToCart(scanner);
                }

            } else if (choice == 2) {

                searchProducts(scanner);

            } else if (choice == 3) {

                System.out.println("Returning to home screen.");

            } else {

                System.out.println("Invalid choice.");
            }
        }
    }
    public void homeScreen() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 3){
            System.out.println("\n===== ONLINE STORE =====");
            System.out.println("1. Display Products");
            System.out.println("2. Display Cart");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");

            choice= scanner.nextInt();

            scanner.nextLine();

            if (choice == 1){
                productScreen(scanner);

            } else if (choice == 2) {
                cart.displayCart();
                System.out.println("Enter the SKU to remove a product");
                System.out.println("Enter 0 to go back. ");

                System.out.println("Your choice: ");
                String sku = scanner.nextLine();

                if(sku.equals("0")){
                    System.out.println("Return to home screen.");
                }
                else{
                    cart.removeProduct(sku);
                }

            } else if (choice == 3) {
                System.out.println("Thank you for visiting our store! ");

            }else{
                System.out.println("Invalid choice. Please try again. ");
            }
        }
    }
}