# Java Banking Ledger

## Project Description

The Java Banking Ledger is a console-based application developed using Java 17. The purpose of this project is to help users manage financial transactions by keeping track of deposits, payments, and transaction history.

Users can navigate through different menus to enter transactions, view their ledger, and generate financial reports. Transaction information is stored in a CSV file so that financial records can be saved and accessed later.

## Features

- **Main Menu:** Navigate through the different application options.
- **Make Deposit:** Record deposits and add money to the ledger.
- **Make Payment:** Record payments and track outgoing money.
- **Ledger Menu:** View and manage transaction history.
- **Reports Menu:** Access financial reports and transaction information.
- **CSV File Storage:** Save and load transaction information.
- **Transaction Details:** Store dates, descriptions, vendors, and amounts.
- **Menu Navigation:** Return to previous menus using the menu options.

## Technologies Used

- Java 17
- IntelliJ IDEA
- CSV (Comma-Separated Values)
- Git and GitHub

## Project Structure

The project is organized into different classes and resources to keep the application easy to manage.

```text
BankingLedger/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── (Java source files)
│       │
│       └── resources/
│           └── transaction.csv
│
└── README.md
```

## How to Run the Application

1. Clone the repository from GitHub.
2. Open the project in IntelliJ IDEA.
3. Make sure Java 17 is installed and configured.
4. Locate the main Java class.
5. Run the application.
6. Follow the menu instructions displayed in the console.

## CSV File

The application uses a CSV file named `transaction.csv` to store transaction information.

The CSV file contains information such as:

- Date
- Description
- Vendor
- Amount

Example transaction:

```text
2026-11-01|Paycheck|Employer|2500.00
2026-11-02|Groceries|Walmart|-125.50
2026-11-03|Gas|Shell|-45.00
2026-11-03|Deposit|Personal Savings|300.00
```

Positive amounts represent deposits, while negative amounts represent payments.

## What I Learned

Building this project helped me improve my understanding of Java programming and application development.

Throughout this project, I gained experience with:

- Creating and organizing Java classes and methods.
- Working with loops and conditional statements.
- Using objects to organize transaction information.
- Handling user input and menu navigation.
- Reading and writing information to CSV files.
- Debugging errors and improving application functionality.
- Using Git and GitHub to manage project changes.

One of my biggest lessons was learning that programming requires patience and problem-solving. Not everything worked the first time, but working through errors helped me become more confident and improve my development skills.

## Author

**Jevauhn Beck**

Java Software Development Student

**Project:** Java Banking Ledger Capstone

**Year:** 2026
