package org.example;

import com.sun.jdi.Value;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LeaseContract extends Contract{

    private BigDecimal expectedEndingValue;
    private BigDecimal leaseFee;

    public LeaseContract(String date, String customerName,
                         String customerEmail, Vehicle vehicleSold){

        super(date, customerName , customerEmail, vehicleSold);

        //Expected ending value is 50% of original price
        expectedEndingValue = vehicleSold.getPrice().multiply
            (new BigDecimal("0.50"));

        //Lease fee is 7% of original price
        leaseFee = vehicleSold.getPrice().multiply(new BigDecimal("0.07"));

    }

    public BigDecimal getExpectedEndingValue(){
        return expectedEndingValue;

    }

    public void setExpectedEndingValue(BigDecimal expectedEndingValue){
        this.expectedEndingValue = expectedEndingValue;

    }
    public BigDecimal getLeaseFee(){
        return leaseFee;
    }
    public void setLeaseFee(BigDecimal leaseFee){
        this.leaseFee = leaseFee;
    }
    @Override
    public BigDecimal getTotalPrice(){
        return expectedEndingValue.add(leaseFee)
            .setScale(2, RoundingMode.HALF_UP);

    }

    @Override
    public BigDecimal getMonthlyPayment(){
        BigDecimal monthlyRate = new BigDecimal("0.04")
            .divide(new BigDecimal("12"),10, RoundingMode.HALF_UP);

        int months = 36;

        double rate = monthlyRate.doubleValue();
        double principal = getTotalPrice().doubleValue();
        double payment = principal * rate /
            (1 - Math.pow(1 + rate, -months));

        return BigDecimal.valueOf(payment).setScale(2, RoundingMode.HALF_UP);
    }

}
