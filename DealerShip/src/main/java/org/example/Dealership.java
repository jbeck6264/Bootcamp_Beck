package org.example;

import java.util.ArrayList;

public class Dealership {

    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address,
                      String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;

        inventory = new ArrayList<Vehicle>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }
    public ArrayList<Vehicle> getAllVehicles(){
        return inventory;
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {

        ArrayList<Vehicle> results = new ArrayList<>();
        for (Vehicle vehicle : inventory){

            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max){
                results.add(vehicle);
            }
        }
        return results;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByType(String type) {
        return null;
    }
}
