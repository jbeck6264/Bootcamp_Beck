package org.example;

import java.util.ArrayList;
import java.util.Scanner;


public class UserInterface {
    private final String GOLD = "\u001B[33m";
    private final String WHITE = "\u001B[37m";
    private final String RESET = "\u001B[0m";

    private Scanner scanner = new Scanner(System.in);

    public void display(){
        DealershipFileManager manager = new DealershipFileManager();

        Dealership dealership = manager.getDealership();

        System.out.println(GOLD + "Welcome to " + dealership.getName()+ RESET);
        System.out.println("Total Vehicles: " +
            dealership.getAllVehicles().size());
        int choice = 0;

        while(choice!= 99) {

            displayMenu();

            choice = scanner.nextInt();

            System.out.println();

            if (choice == 99 ){
                System.out.println(GOLD + "Thank you for visiting Apex One Motors!");

            } else if (choice == 1 ) {

                System.out.println("Enter Minimum price: $");
                double min = scanner.nextDouble();

                System.out.println("Enter maximum price: $");
                double max = scanner.nextDouble();

                ArrayList<Vehicle> results = dealership.getVehiclesByPrice(min, max);

                if (results.isEmpty()){
                    System.out.println("No vehicle foud in this price range.");
                }
                else{
                    System.out.println(GOLD + "\n========== SEARCH RESULTS ==========" + RESET);

                    for(Vehicle vehicle : results){
                        System.out.printf("%d | %d | %s %s | $%,.2f%n",
                            vehicle.getVin(),
                            vehicle.getYear(),
                            vehicle.getMake(),
                            vehicle.getModel(),
                            vehicle.getPrice());
                    }
                }

            } else if (choice == 7){
                System.out.println(GOLD + "\n========== Vehicle Inventory =========="+ RESET);

                for(Vehicle vehicle : dealership.getAllVehicles()){
                    System.out.printf("%d | %d | %s %s | $%,.2f%n",
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getPrice());
                }
            }
            else {
                System.out.println("Option Selected: " + choice);
            }
        }
    }
    public void displayMenu(){
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
