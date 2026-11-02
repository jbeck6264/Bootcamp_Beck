package org.example;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Ledger {
    private ArrayList<Transaction> loadTransactions = new ArrayList<>();

    private String fileName = "transactions.csv";

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

                if (parts.length == 5){

                    Transaction transaction = new Transaction(parts[0], parts[1],
                            parts[2], parts[3],Double.parseDouble(parts[4]));

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
        for (int i = loadTransactions.size() - 1; i >= 0; i--){

        Transaction transaction = loadTransactions.get(i);

            if (transaction.getAmount() > 0) {

                transaction.display();

            }
        }
    }
    public void showPayments(){
        for (int i = loadTransactions.size() - 1; i >= 0; i--){
            Transaction transaction = loadTransactions.get(i);

            if (transaction.getAmount() < 0) {
                transaction.display();
            }
        }
    }
    public void showVendor(String vendor) {

        for (int i = loadTransactions.size() - 1; i >= 0; i--){

            Transaction transaction = loadTransactions.get(i);

            if (transaction.getVendor().equalsIgnoreCase(vendor)){

                transaction.display();
            }
        }

    }
    public void showDataRange(String startDate, String endDate){

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

        System.out.println("\n===== All Transactions =====");
        for (int i = loadTransactions.size() - 1; i>=0; i--) {
            Transaction transaction = loadTransactions.get(i);

            transaction.display();
        }
    }
}




