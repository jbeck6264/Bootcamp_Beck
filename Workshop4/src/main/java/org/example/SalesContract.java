package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalesContract extends Contract{

    private BigDecimal salesTaxAmount;
    private BigDecimal recordingFee;
    private BigDecimal processingFee;
    private boolean financeOption;

    public SalesContract(String date, String customerName,
                         String customerEmail, Vehicle vehicleSold,
                         boolean financeOption) {


        super(date, customerName, customerEmail, vehicleSold);

        this.financeOption = financeOption;

        // calculate 5% sales tax
        salesTaxAmount = vehicleSold.getPrice().multiply(new BigDecimal("0.05"));

        //Recording fee
        recordingFee = new BigDecimal("100.0");

        //Processing fee depends on vehicle price
        if (vehicleSold.getPrice().compareTo(new BigDecimal("10000")) < 0) {

            processingFee = new BigDecimal("295.00");

        } else {
            processingFee = new BigDecimal("495.00");

        }
    }

    public BigDecimal getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(BigDecimal salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public BigDecimal getRecordingFee() {
        return recordingFee;
    }

    public void setRecordFee(BigDecimal recordingFee) {
        this.recordingFee = recordingFee;
    }

    public BigDecimal getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(BigDecimal processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanceOption() {
        return financeOption;
    }

    public void setFinanceOption(boolean financeOption) {
        this.financeOption = financeOption;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return getVehicleSold().getPrice()
            .add(salesTaxAmount)
            .add(recordingFee)
            .add(processingFee)
            .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal getMonthlyPayment() {

        if (!financeOption) {
            return BigDecimal.ZERO;

        }
        BigDecimal interestRate;
        int months;

        if (getVehicleSold().getPrice().compareTo(new BigDecimal("10000")) >= 0) {

            interestRate = new BigDecimal("0.0425");
            months = 48;

        } else {
            interestRate = new BigDecimal("0.0525");
            months = 24;
        }

        // Convert annual interest rate into a monthly rate
        double monthlyRate = interestRate.doubleValue() / 12;
        double principal = getTotalPrice().doubleValue();

        //Calculate monthly payment
        double payment = principal * monthlyRate / (1 - Math.pow(1 + monthlyRate, -months));

        return BigDecimal.valueOf(payment).setScale(2, RoundingMode.HALF_UP);
    }
}
