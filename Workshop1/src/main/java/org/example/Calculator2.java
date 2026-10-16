package org.example;

import java.util.Scanner;

public class Calculator2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter initial Deposit amount: ");
        double p = input.nextDouble();

        System.out.println("Enter annual interest rate: ");
        double r = input.nextDouble() / 100;

        System.out.println("Enter number of years: ");
        int years = input.nextInt();
        int d = 365;
        int n = (d * years);


        System.out.printf("This is the number of days %d ", n );
        double fV = (p*Math.pow(1 +(r / d ), n));
        double totalInterestEarned = (fV - p);

        System.out.println("This is the number Interest Earned: " + totalInterestEarned );
        System.out.println("This is the number of Future Value: " + fV );





    }
}