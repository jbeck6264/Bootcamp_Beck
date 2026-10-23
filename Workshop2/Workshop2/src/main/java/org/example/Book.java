package org.example;

public class Book {
    private int iD;
    private String isBn;
    private String title;
    private boolean isCheckOut;
    private String checkOutTo;

    public Book(int iD, String isBn, String title,
                boolean isCheckOut, String checkOutTo) {
        this.iD = iD;
        this.isBn = isBn;
        this.title = title;
        this.isCheckOut = isCheckOut;
        this.checkOutTo = checkOutTo;

    }

    public int getiD() {
        return iD;
    }

    public String getIsBn() {
        return isBn;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckOut() {
        return isCheckOut;
    }

    public String getCheckOutTo() {
        return checkOutTo;
    }

    public void checkOut(String name) {
        if (isCheckOut == false) {
            isCheckOut = true;
            checkOutTo = name;
        } else {
            System.out.println("Book has been checked out");
        }
    }
    public void checkIn() {
        isCheckOut = false;
        checkOutTo = "";
    }
}
