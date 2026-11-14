package org.example;


import java.awt.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;


public class UserInterface {
    private final String GOLD = "\u001B[33m";
    private final String WHITE = "\u001B[37m";
    private final String RESET = "\u001B[0m";

    private Scanner scanner = new Scanner(System.in);

    public void display() {
        DealershipFileManager manager = new DealershipFileManager();

        Dealership dealership = manager.getDealership();

        System.out.println(GOLD + "Welcome to " + dealership.getName() + RESET);
        System.out.println("Total Vehicles: " +
            dealership.getAllVehicles().size());
        int choice = 0;

        while (choice != 99) {

            displayMenu();

            choice = scanner.nextInt();

            scanner.nextLine();

            System.out.println();

            if (choice == 99) {
                System.out.println(GOLD + "Thank you for visiting Apex One Motors!");

            } else if (choice == 1) {

                System.out.println("Enter Minimum price: $");
                BigDecimal min = scanner.nextBigDecimal();

                System.out.println("Enter maximum price: $");
                BigDecimal max = scanner.nextBigDecimal();

                List<Vehicle> results = dealership.getVehiclesByPrice(min, max);

                if (results.isEmpty()) {
                    System.out.println("No vehicle found in this price range.");
                } else {
                    System.out.println(GOLD + "\n========== SEARCH RESULTS ==========" + RESET);
                    System.out.printf("%-6s | %-4s | %-13s | %-25s | %5s%n",
                        "VIN", "YEAR", "MAKE", "MODEL", "PRICE");

                    System.out.println("-----------------------------------------------------------------------------------");

                    for (Vehicle vehicle : results) {
                        System.out.printf("%-6d | %-4d | %-13s | %-25s | $%9s%n",
                            vehicle.getVin(),
                            vehicle.getYear(),
                            vehicle.getMake(),
                            vehicle.getModel(),
                            String.format("$%,.2fn", vehicle.getPrice().doubleValue()));
                    }
                }
            } else if (choice == 2) {
                System.out.println("Enter vehicle make: ");
                String make = scanner.nextLine();

                System.out.println("Enter vehicle model: ");
                String model = scanner.nextLine();

                List<Vehicle> makeModelResults = dealership.getVehiclesByMakeModel(make, model);

                if (makeModelResults.isEmpty()) {
                    System.out.println("No Vehicle found.");

                } else {
                    System.out.println("\n========== SEARCH RESULTS ==========");
                    System.out.printf("%-6s | %-4s | %-13s | %-25s | %5s%n",
                        "VIN", "YEAR", "MAKE", "MODEL", "PRICE");

                    System.out.println("--------------------------------------------------------------------------------");

                    for (Vehicle vehicle : makeModelResults) {
                        System.out.printf("%-6d | %-4d | %-13s | %-25s | $%9s%n",
                            vehicle.getVin(),
                            vehicle.getYear(),
                            vehicle.getMake(),
                            vehicle.getModel(),
                            vehicle.getPrice(),
                            String.format("$%,.2f%n", vehicle.getPrice().doubleValue()));

                    }

                }
            } else if (choice == 3) {
                System.out.println("Enter starting year: ");
                int minYear = scanner.nextInt();

                System.out.println("Enter ending year: ");
                int maxYear = scanner.nextInt();

                List<Vehicle> yearResults = dealership.getVehiclesByYear(minYear, maxYear);

                if (yearResults.isEmpty()) {
                    System.out.println("No vehicles found in that year range.");

                } else {

                    System.out.println("\n========== SEARCH RESULTS ==========");

                    System.out.printf("%-6s | %-4s | %-13s | %-25s | %5s%n",
                        "VIN", "YEAR", "MAKE", "MODEL", "PRICE");

                    System.out.println("--------------------------------------------------------------------------------");

                    for (Vehicle vehicle : yearResults) {

                        System.out.printf("%-6d | %-4d | %-13s | %-25s | $%9s%n",
                            vehicle.getVin(),
                            vehicle.getYear(),
                            vehicle.getMake(),
                            vehicle.getModel(),
                            vehicle.getPrice(),
                            String.format("$%,.2f%n", vehicle.getPrice().doubleValue()));
                    }

                }
            } else if (choice == 4) {
                System.out.println("Enter vehicle color: ");
                String color = scanner.nextLine();

                List<Vehicle> colorResults = dealership.getVehiclesByColor(color);

                if (colorResults.isEmpty()) {
                    System.out.println("No vehicles found with that color.");

                } else {
                    System.out.println("\n========== SEARCH RESULTS ==========");

                    System.out.printf("%-6s | %-4s | %-13s | %-25s | %-4s | %5s%n",
                        "VIN", "YEAR", "MAKE", "MODEL", "COLOR", "PRICE");

                    System.out.println("----------------------------------------------------------------------------------");

                    for (Vehicle vehicle : colorResults) {

                        System.out.printf("%-6d | %-4d | %-13s | %-25s | %-4s | $%9s%n",
                            vehicle.getVin(),
                            vehicle.getYear(),
                            vehicle.getMake(),
                            vehicle.getModel(),
                            vehicle.getColor(),
                            vehicle.getPrice(),
                            String.format("$%,.2f%n", vehicle.getPrice().doubleValue()));


                    }
                }
            } else if (choice == 5) {
                System.out.println("Enter minium mileage: ");
                int minMileage = scanner.nextInt();

                System.out.println("Enter maximum mileage: ");
                int maxMileage = scanner.nextInt();

                List<Vehicle> mileageResults = dealership.getVehiclesByMileage(minMileage, maxMileage);

                if (mileageResults.isEmpty()) {
                    System.out.println("No vehicles found int that mileage range.");

                } else {
                    System.out.println("\n========== SEARCH RESULTS ==========");

                    System.out.printf("%-6s | %-4s | %-13s | %-23s | %-8s | %5s%n",
                        "VIN", "YEAR", "MAKE", "MODEL", "ODOMETER", "PRICE");

                    System.out.println("-----------------------------------------------------------------------------------");

                    for (Vehicle vehicle : mileageResults) {

                        System.out.printf("%-6d | %-4d | %-13s | %-23s | %-8s | $%9s%n",
                            vehicle.getVin(),
                            vehicle.getYear(),
                            vehicle.getMake(),
                            vehicle.getModel(),
                            vehicle.getOdometer(),
                            vehicle.getPrice(),
                            String.format("$%,.2f%n", vehicle.getPrice().doubleValue()));

                    }
                }
            } else if (choice == 6) {
                System.out.println("Enter vehicle type: ");
                String type = scanner.nextLine();

                List<Vehicle> typeResults = dealership.getVehiclesByType(type);

                if (typeResults.isEmpty()) {
                    System.out.println("No vehicles found in this type.");

                } else {
                    System.out.println("\n========== SEARCH RESULTS ==========");

                    System.out.printf("%-6s | %-4s | %-13s | %-24s | %-8s | %5s%n",
                        "VIN", "YEAR", "MAKE", "MODEL", "TYPE", "PRICE");

                    System.out.println("----------------------------------------------------------------------------------");

                    for (Vehicle vehicle : typeResults) {

                        System.out.printf("%-6d | %-4d | %-13s | %-24s | %-8s | $%9s%n",
                            vehicle.getVin(),
                            vehicle.getYear(),
                            vehicle.getMake(),
                            vehicle.getModel(),
                            vehicle.getVehicleType(),
                            vehicle.getPrice(),
                            String.format("$%,.2f%n", vehicle.getPrice().doubleValue()));


                    }
                }
            } else if (choice == 7) {
                System.out.println(GOLD + "\n========== Vehicle Inventory ==========" + RESET);
                System.out.printf("%-7s| %-5s| %-14s| %-25s| %-5s| %-23s| %-10s | %14s%n",
                    "VIN", "YEAR", "MAKE", "MODEL", "TYPE", "COLOR", "MILEAGE", "PRICE");

                System.out.println("----------------------------------------------------------------------------------------------------------------------------");


                for (Vehicle vehicle : dealership.getAllVehicles()) {
                    System.out.printf("%-7d| %-5d| %-14s| %-25s| %-5s| %-25s | %-10d | $%13s%n",
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getVehicleType(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        vehicle.getPrice(),
                        String.format("$%,.2f%n", vehicle.getPrice().doubleValue()));
                }
            } else if (choice == 8) {

                System.out.println(GOLD + "\n======= ADD NEW VEHICLE =======" + RESET);

                System.out.print("Enter VIN: ");
                int vin = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter year: ");
                int year = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter make: ");
                String make = scanner.nextLine();

                System.out.print("Enter model: ");
                String model = scanner.nextLine();

                System.out.print("Enter vehicle type: ");
                String vehicleType = scanner.nextLine();

                System.out.print("Enter color: ");
                String color = scanner.nextLine();

                System.out.print("Enter mileage: ");
                int odometer = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter price: $");
                BigDecimal price = scanner.nextBigDecimal().setScale(2);

                Vehicle vehicle = new Vehicle(
                    vin, year, make, model, vehicleType,
                    color, odometer, price);

                dealership.addVehicle(vehicle);
                manager.saveDealership(dealership);

                System.out.println(GOLD + "Vehicle successfully added!" + RESET);

            } else if (choice == 9) {
                System.out.println(GOLD + "\n======= REMOVE VEHICLE =======" + RESET);

                System.out.print("Enter VIN of vehicle to remove: ");
                int vin = scanner.nextInt();
                scanner.nextLine();

                Vehicle vehicleToRemove = null;

                for (Vehicle vehicle : dealership.getAllVehicles()) {
                    if (vehicle.getVin() == vin) {
                        vehicleToRemove = vehicle;
                    }
                }

                if (vehicleToRemove != null) {
                    dealership.removeVehicle(vehicleToRemove);
                    manager.saveDealership(dealership);
                    System.out.println(GOLD + "Vehicle successfully removed!" + RESET);

                } else {
                    System.out.println("Vehicle not found.");
                }
            } else {
                System.out.println("Option Selected: " + choice);
            }
        }
    }

    private void displayMenu() {
        System.out.println(GOLD + "\n");
        System.out.println("       ✦ APEX ONE ✦");
        System.out.println("     L U X U R Y  M O T O R S");
        System.out.println("  EXOTIC  •  SUPERCAR  •  HYPERCAR");
        System.out.println("======================================");

        System.out.println("         INVENTORY MANAGEMENT");
        System.out.println("--------------------------------------");

        System.out.println(WHITE + "  01  ›  Search by Price");
        System.out.println("  02  ›  Search by Make / Model");
        System.out.println("  03  ›  Search by Year");
        System.out.println("  04  ›  Search by Color");
        System.out.println("  05  ›  Search by Mileage");
        System.out.println("  06  ›  Search by Vehicle Type");
        System.out.println("  07  ›  View All Vehicles");
        System.out.println("  08  ›  Add New Vehicle");
        System.out.println("  09  ›  Remove Vehicle");

        System.out.println(GOLD + "--------------------------------------");
        System.out.println("  99  ›  EXIT APPLICATION");
        System.out.println("======================================" + RESET);

        System.out.print("  SELECT YOUR OPTION: ");
    }
}

