package org.example;

public class Transaction {
    private String date;
    private String time;
    private String description;
    private String vendor;
    private double amount;

    public double getAmount() {
        return amount;
    }

    public String getVendor() {
        return vendor;
    }

    public String getDescription() {
        return description;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public Transaction(String date, String time, String description,
                       String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;

    }
    public String toCSV(){
        return date + "|" + time + "|" + description + "|" +
                vendor + "|" + amount;
    }
    public void display() {
        System.out.printf("%-12s %-12s %-22s %-18s $%.2f%n",
                date, time, description, vendor, amount);
    }
}
