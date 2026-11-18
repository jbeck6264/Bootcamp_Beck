package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Asset> myAssets = new ArrayList<>();

        loadAssets(myAssets);

        displayAssets(myAssets);
    }

    // Load Assets
    public static void loadAssets(ArrayList<Asset> myAssets) {

        myAssets.add(new House(
            "My house", "2022-05-15",
            new BigDecimal("315000.00"),
            "Charlotte, NC", 1, 2000, 8000));

        myAssets.add(new House(
            "Vacation home",
            "2023-08-20",
            new BigDecimal("250000.00"), "Myrtle Beach, SC",
            2, 1800, 6000));

        myAssets.add(new Vehicle(
            "My truck", "2024-01-10",
            new BigDecimal("55000.00"),
            "Ford F-150", 2022, 75000));

        myAssets.add(new Vehicle(
            "Tom's car", "2021-06-12",
            new BigDecimal("30000.00"),
            "Toyota Camry", 2018, 125000));
    }

    // Display Assets
    public static void displayAssets(ArrayList<Asset> myAssets) {

        for (Asset asset : myAssets) {

            String message = "";

            if (asset instanceof House) {

                House house = (House) asset;
                message = "Address: " + house.getAddress();

            } else if (asset instanceof Vehicle) {

                Vehicle vehicle = (Vehicle) asset;
                message = "Vehicle: " + vehicle.getYear()
                    + " " + vehicle.getMakeModel();
            }

            System.out.println("--------------------------------");
            System.out.println(asset.getDescription());
            System.out.println(message);
            System.out.println("Date Acquired: " + asset.getDateAcquired());
            System.out.printf("Original Cost: $%,.2f%n" , asset.getOriginalCost());
            System.out.printf("Current Value: $%,.2f%n" ,  asset.getValue());
        }
    }
}