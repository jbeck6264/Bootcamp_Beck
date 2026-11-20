package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {

    private final String fileName = "src/main/resources/contracts.csv";

    public void saveContract(Contract contract) {

        File file = new File(fileName);

        try {
            BufferedWriter writer = new BufferedWriter(
                new FileWriter(fileName, true));

            // Write headers if the file is new or empty
            if (!file.exists() || file.length() == 0) {
                writer.write("CONTRACT_TYPE|DATE|CUSTOMER_NAME|CUSTOMER_EMAIL|VIN|YEAR|MAKE|MODEL|VEHICLE_TYPE|COLOR|ODOMETER|VEHICLE_PRICE|CONTRACT_DETAILS");
                writer.newLine();
            }

            Vehicle vehicle = contract.getVehicleSold();

            String line;

            if (contract instanceof SalesContract) {

                SalesContract sale = (SalesContract) contract;

                line = "SALE|" +
                    contract.getDate() + "|" +
                    contract.getCustomerName() + "|" +
                    contract.getCustomerEmail() + "|" +
                    vehicle.getVin() + "|" +
                    vehicle.getYear() + "|" +
                    vehicle.getMake() + "|" +
                    vehicle.getModel() + "|" +
                    vehicle.getVehicleType() + "|" +
                    vehicle.getColor() + "|" +
                    vehicle.getOdometer() + "|" +
                    vehicle.getPrice().toPlainString() + "|" +
                    sale.getSalesTaxAmount().toPlainString() + "|" +
                    sale.getRecordingFee().toPlainString() + "|" +
                    sale.getProcessingFee().toPlainString() + "|" +
                    sale.getTotalPrice().toPlainString() + "|" +
                    (sale.isFinanceOption() ? "YES" : "NO") + "|" +
                    sale.getMonthlyPayment().toPlainString();

            } else if (contract instanceof LeaseContract) {

                LeaseContract lease = (LeaseContract) contract;

                line = "LEASE|" +
                    contract.getDate() + "|" +
                    contract.getCustomerName() + "|" +
                    contract.getCustomerEmail() + "|" +
                    vehicle.getVin() + "|" +
                    vehicle.getYear() + "|" +
                    vehicle.getMake() + "|" +
                    vehicle.getModel() + "|" +
                    vehicle.getVehicleType() + "|" +
                    vehicle.getColor() + "|" +
                    vehicle.getOdometer() + "|" +
                    vehicle.getPrice().toPlainString() + "|" +
                    lease.getExpectedEndingValue().toPlainString() + "|" +
                    lease.getLeaseFee().toPlainString() + "|" +
                    lease.getTotalPrice().toPlainString() + "|" +
                    lease.getMonthlyPayment().toPlainString();

            } else {
                writer.close();
                return;
            }

            writer.write(line);
            writer.newLine();
            writer.close();

            System.out.println("Contract saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving contract: " + e.getMessage());
        }
    }
}