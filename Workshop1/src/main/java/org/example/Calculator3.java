package org.example;

import java.util.Scanner;

public class Calculator3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter monthly payout: ");
        double payout = input.nextDouble();

        System.out.print("Enter annual interest rate (%): ");
        double annualRate = input.nextDouble();

        System.out.print("Enter number of years: ");
        int years = input.nextInt();

        double monthlyRate = annualRate / 100 / 12;
        int months = years * 12;

        double presentValue = payout * (1 - Math.pow(1 + monthlyRate, - months)) / monthlyRate;

        System.out.printf("Present value: $%,.2f%n", presentValue);
    }
}
