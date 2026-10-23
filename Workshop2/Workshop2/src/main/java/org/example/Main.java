package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] Books = new Book[20];
        int count = 20;

        Books[0] = new Book(1, "111","Harry Potter", false, "");
        Books[1] = new Book(2, "222","The Shining", false, "");
        Books[2] = new Book(3, "333","The Notebook", false, "");
        Books[3] = new Book(4, "444","The Hobbit", true, "Tom");
        Books[4] = new Book(5, "555","Dune", false, "");
        Books[5] = new Book(6, "666","The Great Gatsby", false, "");
        Books[6] = new Book(7, "777","The Hunger Games", true, "Jim");
        Books[7] = new Book(8, "888","Dracula", true, "Bobby");
        Books[8] = new Book(9, "999","The Da Vinci Code", true, "Kelvin");
        Books[9] = new Book(10, "101","Steve Jobs", false, "");
        Books[10] = new Book(11, "112","The Art of War", false, "");
        Books[11] = new Book(12, "123","The Book Thief", false, "");
        Books[12] = new Book(13, "134","The Cat in the Hat", true, "Jevauhn");
        Books[13] = new Book(14, "145","Watchmen", false, "");
        Books[14] = new Book(15, "156","The Odyssey", false, "");
        Books[15] = new Book(16, "167","The Silent Patient", false, "");
        Books[16] = new Book(17, "178","The Alchemist", true, "Gisell");
        Books[17] = new Book(18, "189","The Martian", false, "");
        Books[18] = new Book(19, "190","The Outsiders", false, "");
        Books[19] = new Book(20, "201","Sherlock Holmes", false, "");


        while (true) {
            System.out.println(" *******    HOME SCREEN    *******     ");
            System.out.println("1- Show Available Books: ");
            System.out.println("2- Show Checked Out Books: ");
            System.out.println("3- Exit");
            System.out.println("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                System.out.println("Available Books: ");
                for (Book book : Books) {
                    if (!book.isCheckOut()) {
                        System.out.println(" Book iD: " + book.getiD() + " IsBn : " + book.getIsBn() + " Title: " + book.getTitle());
                    }
                }
                System.out.println("Enter book ID (0 to go back): ");
                int id = Integer.parseInt(scanner.nextLine());

                if (id != 0) {
                    for (Book book : Books) {
                        if (book.getiD() == id && !book.isCheckOut()) {
                            System.out.println("Enter your Name: ");
                            String Barba = scanner.nextLine();
                            book.checkOut(Barba);
                            System.out.println(Barba + " Checked out a book!");
                        }
                    }
                }
            } else if (choice == 2){

                System.out.println("Check Out Books: ");
                for (Book book : Books) {
                    if (book.isCheckOut()) {
                        System.out.println(" Book iD: " + book.getiD() + " IsBn : " + book.getIsBn() + " Title: " + book.getTitle());
                    }
                }
                System.out.print("Enter C to check in or X to go back: ");
                String option = scanner.nextLine();

                if (option.equalsIgnoreCase("C")) {
                    System.out.print("Enter book ID: ");
                    int iD = Integer.parseInt(scanner.nextLine());

                    for (Book book : Books) {
                        if (book.getiD() == iD && book.isCheckOut()) {
                            System.out.printf("%s Checked back in the book! %n", book.getCheckOutTo());
                            book.checkIn();
                        }
                    }
                }
            }
            else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}