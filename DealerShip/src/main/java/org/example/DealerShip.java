package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DealerShip {

    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<Vehicle> inventory;

    public DealerShip(String name, String address,
                      String phoneNumber, ArrayList<Vehicle> inventory) {
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

    public ArrayList<Vehicle>getAllVehicles(){
        return inventory;
    }

    public ArrayList<Vehicle>getVehiclesByPrice(double min, double max){
        return null;
    }

    public ArrayList<Vehicle>getVehicleMakeModel(String make, String model){
        return null;
    }

    public ArrayList<Vehicle>getVehicleByYear(int min, int max){
        return null;
    }

    public ArrayList<Vehicle> getInventory() {
        return null;
    }

    public void removeVehicle(Vehicle vehicle){

    }
}
