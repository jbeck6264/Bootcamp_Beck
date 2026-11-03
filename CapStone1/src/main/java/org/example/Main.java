package org.example;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Ledger ledger = new Ledger();

        boolean running = true;

        while (running) {

            System.out.println("============================================================");
            System.out.println("  ███████╗██╗███╗   ██╗ █████╗ ███╗   ██╗ ██████╗██╗ █████╗ ██╗");
            System.out.println("  ██╔════╝██║████╗  ██║██╔══██╗████╗  ██║██╔════╝██║██╔══██╗██║");
            System.out.println("  █████╗  ██║██╔██╗ ██║███████║██╔██╗ ██║██║     ██║███████║██║");
            System.out.println("  ██╔══╝  ██║██║╚██╗██║██╔══██║██║╚██╗██║██║     ██║██╔══██║██║");
            System.out.println("  ██║     ██║██║ ╚████║██║  ██║██║ ╚████║╚██████╗██║██║  ██║███████╗");
            System.out.println("  ╚═╝     ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝╚═╝╚═╝  ╚═╝╚══════╝");
            System.out.println();
            System.out.println("                    F I N A N C I A L");
            System.out.println("                       T R A C K E R");
            System.out.println("============================================================");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");

            System.out.println("Choose an Option: ");

            String choice = scanner.nextLine().toLowerCase();

            if (choice.equalsIgnoreCase("D")) {

                addDeposit(scanner, ledger);

            } else if (choice.equalsIgnoreCase("P")) {
                System.out.println("Make Payment selected.");
                makePayment(scanner, ledger);

            } else if (choice.equalsIgnoreCase("L")){
                System.out.println("Ledger selected. ");
                ledgerMenu(scanner, ledger);

            } else if (choice.equalsIgnoreCase("X")){
                running = false;
                System.out.println("Thank you for using our Financial Tracker, goodbye!");

            } else {
                System.out.println("Invalid option. Try again.");
            }


        }
        scanner.close();
    }
    public static void addDeposit(Scanner scanner, Ledger ledger){

        System.out.println("""
          █████╗  ██████╗
         ██╔══██╗ ██╔══██╗
         ███████║ ██║  ██║
         ██╔══██║ ██║  ██║
         ██║  ██║ ██████╔╝
         ╚═╝  ╚═╝ ╚═════╝
      A D D    D E P O S I T
     """);
        System.out.println("Enter Description: ");
        String description = scanner.nextLine();

        System.out.println("Enter Vendor: ");
        String vendor = scanner.nextLine();

        System.out.println("Enter Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        if (amount <= 0) {
            System.out.println("Deposit must be greater than zero");
            return;
        }
        String date = java.time.LocalDate.now().toString();

        String time = java.time.LocalTime.now().format(
                java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));

        Transaction transaction = new Transaction(
                date, time, description, vendor, amount);

        ledger.saveTransaction(transaction);

    }
    public static void makePayment(Scanner scanner, Ledger ledger){

        System.out.println("""
         ███╗   ███╗  ██████╗
         ████╗ ████║  ██╔══██╗
         ██╔████╔██║  ██████╔╝
         ██║╚██╔╝██║  ██╔═══╝
         ██║ ╚═╝ ██║  ██║
         ╚═╝     ╚═╝  ╚═╝

      M A K E    P A Y M E N T
    """);

        System.out.println("Enter Description:");
        String description = scanner.nextLine();

        System.out.println("Enter Vendor: ");
        String vendor = scanner.nextLine();

        System.out.println("Enter Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        if(amount <= 0){
            System.out.println("Payment must be greater than zero. ");
            return;
        }
        amount = -amount;
        String date = java.time.LocalDate.now().toString();

        String time = java.time.LocalTime.now().format(
                java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));

        Transaction transaction = new Transaction(
                date, time, description, vendor, amount);

        ledger.saveTransaction(transaction);
    }
    public static void ledgerMenu(Scanner scanner, Ledger ledger) {

        boolean inLedger = true;

        while (inLedger) {

            System.out.println("""
    ██╗     ███╗   ███╗
    ██║     ████╗ ████║
    ██║     ██╔████╔██║
    ██║     ██║╚██╔╝██║
    ███████╗██║ ╚═╝ ██║
    ╚══════╝╚═╝     ╚═╝

    L E D G E R   M E N U
""");
            System.out.println("A) All Transactions");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            System.out.println("Choose an option: ");

            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("A")){
                ledger.showAll();

            }else if (choice.equalsIgnoreCase("D")){
                ledger.showDeposits();

            }else if (choice.equalsIgnoreCase("P")){
                ledger.showPayments();

            }else if (choice.equalsIgnoreCase("R")){
                reportsMenu(scanner, ledger);

            }else if (choice.equalsIgnoreCase("H")){
                inLedger = false;

            } else {
                System.out.println("Invalid option.");
            }

        }
    }
    public static void reportsMenu(Scanner scanner, Ledger ledger){

        boolean inReports = true;

        while (inReports){

            System.out.println("""
         ██████╗ ███╗   ███╗
         ██╔══██╗████╗ ████║
         ██████╔╝██╔████╔██║
         ██╔══██╗██║╚██╔╝██║
         ██║  ██║██║ ╚═╝ ██║
         ╚═╝  ╚═╝╚═╝     ╚═╝

        R E P O R T S  M E N U
    """);
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year to Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("0) Back");

            System.out.println("Choose an option: ");

            String choice = scanner.nextLine();

            if (choice.equals("5")){

                System.out.println("Enter Vendor: ");
                String vendor = scanner.nextLine();

                ledger.showVendor(vendor);

            }else if (choice.equals("0")){

                inReports = false;

            } else {
                System.out.println("We will add this report next.");
            }

        }
    }
}

