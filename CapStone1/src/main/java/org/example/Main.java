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

            } else if (choice.equalsIgnoreCase("L")){
                System.out.println("Ledger selected. ");

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
       ADD DEPOSIT
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

        String time = java.time.LocalTime.now().toString();

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

     MAKE PAYMENT
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

        String time = java.time.LocalTime.now().toString();

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

      LEDGER MENU
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
                ledger.showPayments();

            }else if (choice.equalsIgnoreCase("P")){
                ledger.showPayments();

            }else if (choice.equalsIgnoreCase("R")){
                System.out.println("Report coming soon!");

            }else if (choice.equalsIgnoreCase("H")){
                inLedger = false;

            } else {
                System.out.println("Invalid option.");
            }

        }
    }
}

