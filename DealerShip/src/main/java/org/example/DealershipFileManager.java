package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {
    public Dealership getDealership(){

        try{
            BufferedReader reader = new BufferedReader
                (new FileReader("src/main/resources/apex_hypercar_inventory.csv"));

            String firstLine = reader.readLine();

            String[]dealershipsInfo = firstLine.split("\\|");

            String name = dealershipsInfo[0];
            String address = dealershipsInfo[1];
            String phoneNumber = dealershipsInfo[2];

            Dealership dealership = new Dealership(name, address, phoneNumber);

            String vehicleLine;

            while((vehicleLine = reader.readLine()) !=null){
                String[] vehicleInfo = vehicleLine.split("\\|");
                Vehicle vehicle = new Vehicle(Integer.parseInt(vehicleInfo[0]), Integer.parseInt(vehicleInfo[1]),
                vehicleInfo[2],
                vehicleInfo[3],
                vehicleInfo[4],
                vehicleInfo[5],
                Integer.parseInt(vehicleInfo[6]),
                Double.parseDouble(vehicleInfo[7]));

                dealership.addVehicle(vehicle);
            }
            reader.close();

            return dealership;

        }catch (IOException ex){
            System.out.println("Error reading dealership file.");
        }
        return null;

    }
}
