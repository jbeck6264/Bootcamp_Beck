package org.example;

import java.util.Scanner;

public class Calculator1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Loan amount: ");
        double p = input.nextDouble();

        System.out.print("Enter annual interset rate (%): ");
        double annualRate = input.nextDouble();

        System.out.print("Enter loan length in years: ");
        int years = input.nextInt();
        double r = (annualRate / 100) /12;
        int n = years *12;
        double m = (p*(r * Math.pow(1 + r, n))/ (Math.pow(1 + r, n)-1));
        System.out.println("This is your monthly payment $" + m);
        double t = ((m * n) - p);
        System.out.println("This is your Total interest " + t);





    }
}
