package org.example;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static final String RESET = "\u001B[0m";

    public static final String CYAN = "\u001B[36m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String UNDERLINE = "\u001B[4m";
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Ledger ledger = new Ledger();

        boolean running = true;

        while (running) {

            System.out.println(CYAN + "=====================================================================");
            System.out.println("  ███████╗██╗███╗   ██╗ █████╗ ███╗   ██╗ ██████╗██╗ █████╗ ██╗");
            System.out.println("  ██╔════╝██║████╗  ██║██╔══██╗████╗  ██║██╔════╝██║██╔══██╗██║");
            System.out.println("  █████╗  ██║██╔██╗ ██║███████║██╔██╗ ██║██║     ██║███████║██║");
            System.out.println("  ██╔══╝  ██║██║╚██╗██║██╔══██║██║╚██╗██║██║     ██║██╔══██║██║");
            System.out.println("  ██║     ██║██║ ╚████║██║  ██║██║ ╚████║╚██████╗██║██║  ██║███████╗");
            System.out.println("  ╚═╝     ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝╚═╝╚═╝  ╚═╝╚══════╝");
            System.out.println();
            System.out.println(UNDERLINE + "                       F I N A N C I A L");
            System.out.println(UNDERLINE + "                         T R A C K E R");
            System.out.println("====================================================================" + RESET);
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

            } else if (choice.equalsIgnoreCase("L")) {
                System.out.println("Ledger selected. ");
                ledgerMenu(scanner, ledger);

            } else if (choice.equalsIgnoreCase("X")) {
                running = false;
                System.out.println("Thank you for using our Financial Tracker, goodbye!");

            } else {
                System.out.println("Invalid option. Try again.");
            }


        }
        scanner.close();
    }

    public static void addDeposit(Scanner scanner, Ledger ledger) {

        System.out.println(PURPLE + """
                     █████╗  ██████╗
                    ██╔══██╗ ██╔══██╗
                    ███████║ ██║  ██║
                    ██╔══██║ ██║  ██║
                    ██║  ██║ ██████╔╝
                    ╚═╝  ╚═╝ ╚═════╝
                
                 A D D    D E P O S I T
                """ + RESET);
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

    public static void makePayment(Scanner scanner, Ledger ledger) {

        System.out.println(GREEN + """
                     ███╗   ███╗  ██████╗
                     ████╗ ████║  ██╔══██╗
                     ██╔████╔██║  ██████╔╝
                     ██║╚██╔╝██║  ██╔═══╝
                     ██║ ╚═╝ ██║  ██║
                     ╚═╝     ╚═╝  ╚═╝
                
                   M A K E    P A Y M E N T
               
                """ + RESET);

        System.out.println("Enter Description:");
        String description = scanner.nextLine();

        System.out.println("Enter Vendor: ");
        String vendor = scanner.nextLine();

        System.out.println("Enter Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        if (amount <= 0) {
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

            System.out.println(YELLOW + """
                        ██╗     ███╗   ███╗
                        ██║     ████╗ ████║
                        ██║     ██╔████╔██║
                        ██║     ██║╚██╔╝██║
                        ███████╗██║ ╚═╝ ██║
                        ╚══════╝╚═╝     ╚═╝
                    
                        L E D G E R   M E N U
                    """ + RESET);
            System.out.println("A) All Transactions");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            System.out.println("Choose an option: ");

            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("A")) {
                ledger.showAll();

            } else if (choice.equalsIgnoreCase("D")) {
                ledger.showDeposits();

            } else if (choice.equalsIgnoreCase("P")) {
                ledger.showPayments();

            } else if (choice.equalsIgnoreCase("R")) {
                reportsMenu(scanner, ledger);

            } else if (choice.equalsIgnoreCase("H")) {
                inLedger = false;

            } else {
                System.out.println("Invalid option.");
            }

        }
    }

    public static void reportsMenu(Scanner scanner, Ledger ledger) {

        boolean inReports = true;

        while (inReports) {

            System.out.println(RED + """
                         ██████╗ ███╗   ███╗
                         ██╔══██╗████╗ ████║
                         ██████╔╝██╔████╔██║
                         ██╔══██╗██║╚██╔╝██║
                         ██║  ██║██║ ╚═╝ ██║
                         ╚═╝  ╚═╝╚═╝     ╚═╝
                    
                        R E P O R T S  M E N U
                    """ + RESET);
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year to Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Custom Search");
            System.out.println("0) Back");

            System.out.println("Choose an option: ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                String startDate = java.time.LocalDate.now()
                        .withDayOfMonth(1).toString();

                String endDate = java.time.LocalDate.now().toString();

                System.out.println("\n===== Month To Date =====");
                ledger.showDataRange(startDate, endDate);

            } else if (choice.equals("2")) {
                java.time.LocalDate previousMonth =
                        java.time.LocalDate.now().minusMonths(1);

                String startDate = previousMonth.withDayOfMonth(1).toString();

                String endDate = previousMonth.withDayOfMonth
                        (previousMonth.lengthOfMonth()).toString();

                System.out.println("\n===== Previous Month =====");

                ledger.showDataRange(startDate, endDate);

            } else if (choice.equals("3")) {

                String startDate = java.time.LocalDate.now()
                        .withDayOfYear(1).toString();
                String endDate = java.time.LocalDate.now().toString();

                System.out.println("\n===== Year to Date =====");

                ledger.showDataRange(startDate, endDate);

            } else if (choice.equals("4")) {

                java.time.LocalDate previousYear =
                        java.time.LocalDate.now().minusYears(1);

                String startDate = previousYear.withDayOfYear(1).toString();

                String endDate = previousYear.withDayOfYear(
                        previousYear.lengthOfYear()).toString();

                System.out.println("===== PREVIOUS YEAR =====");

                ledger.showDataRange(startDate, endDate);

            } else if (choice.equals("5")) {

                System.out.println("\n===== CUSTOM SEARCH =====");
                System.out.println("1) Search by Vendor");
                System.out.println("2) Search by Description");
                System.out.println("3) Search by Date");

                System.out.print("Choose an option: ");
                String searchChoice = scanner.nextLine();

                if (searchChoice.equals("1")) {

                    System.out.print("Enter Vendor: ");
                    String vendor = scanner.nextLine();

                    ledger.showVendor(vendor);

                } else if (searchChoice.equals("2")) {

                    System.out.print("Enter Description: ");
                    String description = scanner.nextLine();

                    ledger.showDescription(description);

                } else if (choice.equals("3")) {
                    System.out.println("Enter Date (YYYY-MM-DD): ");
                   String date = scanner.nextLine();

                } else {
                    System.out.println("Invalid option.");
                }

            }
        }
    }
}

