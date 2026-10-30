package org.example;

public class Product {
    private String sku;
    private String productName;
    private double price;
    private String department;

    public String getSku() {
        return sku;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDepartment() {
        return department;
    }

    public Product(String sku, String productName, double price,
                   String deparment) {
        this.sku = sku;
        this.productName = productName;
        this.price = price;
        this.department = deparment;
    }

        public void displayProduct() {
            System.out.printf("%s | %s | $%.2f | %s%n",
                    sku, productName, price, department);


        }
    }
