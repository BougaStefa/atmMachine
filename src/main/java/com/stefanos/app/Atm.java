package com.stefanos.app;

import java.util.List;
import java.util.Scanner;

public class Atm {
  private List<Bank> banks;

  public Atm(List<Bank> banks) {
    this.banks = banks;
  }

  public void processTransaction(int accNo, int pin, Scanner scanner) {
    String bankID = String.valueOf(accNo).substring(0, 2);
    Bank bank = getBankByID(bankID);

    if (bank != null) {
      User user = bank.getUser(accNo, pin);
      if (user != null) {
        System.out.println("Account " + accNo + " authenticated.");
        // OPERATION TO BE ADDED
        showMenu(user, bank, scanner);
      } else {
        System.out.println("Authentication failed.");
      }
    } else {
      System.out.println("Bank not supported.");
    }
  }

  private void showMenu(User user, Bank bank, Scanner scanner) {
    while (true) {
      System.out.println("\nMENU:");
      System.out.println("1. Check Balance");
      System.out.println("2. Deposit");
      System.out.println("3. Withdraw");
      System.out.println("4. Exit");

      System.out.println("Choose an option:");
      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          checkBalance(user);
          break;
        case 2:
          deposit(user, bank, scanner);
          break;
        case 3:
          withdraw(user, bank, scanner);
          break;
        case 4:
          System.out.println("Thank you for using my ATM. Goodbye!");
          return;
        default:
          System.out.println("Invalid option, please try again.");
      }
    }
  }

  private void checkBalance(User user) {
    System.out.println("Your balance is: " + user.getBalance());
  }

  private void deposit(User user, Bank bank, Scanner scanner) {
    System.out.println("Enter a deposit amount: ");
    double amount = scanner.nextDouble();
    if (amount > 0) {
      user.deposit(amount);
      bank.updateUser(user);
      System.out.println("Deposited £" + amount + ". New balance: £" + user.getBalance());
    } else {
      System.out.println("Invalid amount. Please enter a positive number");
    }
  }

  private void withdraw(User user, Bank bank, Scanner scanner) {
    System.out.println("Enter withdrawal amount");
    double amount = scanner.nextDouble();

    if (amount > 0 && amount <= user.getBalance()) {
      user.withdraw(amount);
      bank.updateUser(user);
      System.out.println("Withdrew £" + amount + ". New balance: £" + user.getBalance());
    } else if (amount > user.getBalance()) {
      System.out.println("Insufficient funds.");
    } else {
      System.out.println("Invalid amount. Please enter a positive number.");
    }
  }

  public Bank getBankByID(String bankID) {
    for (Bank bank : banks) {
      if (bank.getBankID().equals(bankID)) {
        return bank;
      }
    }
    return null;
  }
}
