package org.example;


import java.math.BigDecimal;

public class House extends Asset {

    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    public House(String description, String dateAcquired, BigDecimal originalCost,
                 String address, int condition, int squareFoot, int lotSize) {

        super(description, dateAcquired, originalCost);

        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondtion(int condtion) {
        this.condition = condtion;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    @Override
    public BigDecimal getValue(){

        BigDecimal pricePerFoot;

        if(condition == 1){
            pricePerFoot = new BigDecimal("180.00");
        }else if (condition == 2){
            pricePerFoot = new BigDecimal("130.00");
        }else if (condition == 3){
            pricePerFoot = new BigDecimal("90.00");
        }else {
            pricePerFoot = new BigDecimal("80.00");
        }
        BigDecimal houseValue = pricePerFoot.multiply(BigDecimal.valueOf(squareFoot));

        BigDecimal lotValue = new BigDecimal("0.25").multiply(BigDecimal.valueOf(lotSize));

        return houseValue.add(lotValue);
    }
}
