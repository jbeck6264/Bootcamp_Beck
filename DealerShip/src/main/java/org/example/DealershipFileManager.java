package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class DealershipFileManager {
    public Dealership getDealership() {

        try {
            BufferedReader reader = new BufferedReader
                (new FileReader("src/main/resources/apex_hypercar_inventory.csv"));

            String firstLine = reader.readLine();

            String[] dealershipsInfo = firstLine.split("\\|");

            String name = dealershipsInfo[0];
            String address = dealershipsInfo[1];
            String phoneNumber = dealershipsInfo[2];

            Dealership dealership = new Dealership(name, address, phoneNumber);

            String vehicleLine;

            while ((vehicleLine = reader.readLine()) != null) {
                String[] vehicleInfo = vehicleLine.split("\\|");
                Vehicle vehicle = new Vehicle(Integer.parseInt(vehicleInfo[0]), Integer.parseInt(vehicleInfo[1]),
                    vehicleInfo[2],
                    vehicleInfo[3],
                    vehicleInfo[4],
                    vehicleInfo[5],
                    Integer.parseInt(vehicleInfo[6]),
                    new BigDecimal(vehicleInfo[7]));

                dealership.addVehicle(vehicle);
            }
            reader.close();

            return dealership;

        } catch (IOException ex) {
            System.out.println("Error reading dealership file.");
        }
        return null;

    }

    public void saveDealership(Dealership dealership) {
        try {
            BufferedWriter writer = new BufferedWriter(
                new FileWriter("src/main/resources/apex_hypercar_inventory.csv"));

            // Save dealership information
            writer.write(dealership.getName() + "|" +
                dealership.getAddress() + "|" +
                dealership.getPhoneNumber());

            writer.newLine();

            // Save all vehicles
            for (Vehicle vehicle : dealership.getAllVehicles()) {

                writer.write(
                    vehicle.getVin() + "|" +
                        vehicle.getYear() + "|" +
                        vehicle.getMake() + "|" +
                        vehicle.getModel() + "|" +
                        vehicle.getVehicleType() + "|" +
                        vehicle.getColor() + "|" +
                        vehicle.getOdometer() + "|" +
                        vehicle.getPrice().toPlainString()
                );

                writer.newLine();
            }

            writer.close();

        } catch (IOException ex) {
            System.out.println("Error saving dealership file.");

        }
    }
}
