package org.example;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Ledger {
    private ArrayList<Transaction> loadTransactions = new ArrayList<>();

    private String fileName = "src/main/resources/transaction.csv";

    public Ledger() {
        loadTransactions();
    }
    public void loadTransactions() {

        loadTransactions.clear();

        try {
            File file = new File(fileName);

            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader reader = new BufferedReader
                    (new FileReader(file));

            String line;

            while((line = reader.readLine())!= null){

                String[] parts = line.split("\\|");
                if (parts[0].equals("Date")) {
                    continue;
                }

                if (parts.length == 5){

                    String date = parts[0].trim();
                    String time = parts[1].trim();
                    String description = parts[2].trim();
                    String vendor = parts[3].trim();
                    double amount = Double.parseDouble(parts[4].trim());

                    Transaction transaction = new Transaction
                            (date, time, description, vendor, amount);

                    loadTransactions.add(transaction);

                }
            }
            reader.close();

        } catch(IOException ex){
            System.out.println("Error reading transactions.");
        }
    }
    public void saveTransaction(Transaction transaction){

        try{
            FileWriter writer = new FileWriter(fileName, true);

            writer.write( transaction.toCSV() + "\n");
            writer.close();
            loadTransactions.add(transaction);
            System.out.println("Transaction Saved! ");
        }
        catch (IOException ex){
            System.out.println("Error saving the transaction.");
        }
    }

    public void showALl(){
        Collections.reverse(loadTransactions);

        for (Transaction transaction : loadTransactions){
            transaction.display();
        }

        Collections.reverse(loadTransactions);

    }

    public void showDeposits() {

        System.out.println("\n===== DEPOSITS =====");
        System.out.printf("%-12s %-12s %-22s %-18s %s%n",
                "Date", "Time", "Description", "Vendor", "Amount");

        for (int i = loadTransactions.size() - 1; i >= 0; i--) {

            Transaction transaction = loadTransactions.get(i);

            if (transaction.getAmount() > 0) {
                transaction.display();

            }
        }
    }
    public void showPayments(){

        System.out.println("\n===== Payments =====");
        System.out.printf("%-12s %-12s %-22s %-18s %s%n",
                "Date", "Time", "Description", "Vendor", "Amount");

        for (int i = loadTransactions.size() - 1; i >= 0; i--){
            Transaction transaction = loadTransactions.get(i);

            if (transaction.getAmount() < 0) {
                transaction.display();
            }
        }
    }
    public void showVendor(String vendor) {

        System.out.println("\n===== Vendor Search =====");
        System.out.printf("%-12s %-12s %-22s %-18s %s%n",
                "Date", "Time", "Description", "Vendor", "Amount");

        for (int i = loadTransactions.size() - 1; i >= 0; i--){

            Transaction transaction = loadTransactions.get(i);

            if (transaction.getVendor().equalsIgnoreCase(vendor)){
                transaction.display();
            }
        }

    }
    public void showDataRange(String startDate, String endDate){

        System.out.println("\n===== Start/End Date Search =====");

        for (int i = loadTransactions.size() -1; i >= 0; i--){

            Transaction transaction = loadTransactions.get(i);

            String date = transaction.getDate();

            if (date.compareTo(startDate) >= 0
                && date.compareTo(endDate) <= 0) {
                transaction.display();
            }
        }
    }

    public void showAll() {

        System.out.println("\n===== ALL TRANSACTIONS =====");

        System.out.printf("%-12s %-12s %-22s %-18s %s%n",
                "Date", "Time", "Description", "Vendor", "Amount");

        for (int i = loadTransactions.size() - 1; i >= 0; i--) {

            Transaction transaction = loadTransactions.get(i);

            transaction.display();
        }
    }
}




