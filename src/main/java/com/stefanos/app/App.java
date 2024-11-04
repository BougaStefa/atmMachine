package com.stefanos.app;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    // Test data for banks and users
    Bank bos = new Bank("12");
    bos.addUser(new User(123456, 500.0, 1234));
    bos.addUser(new User(123444, 6969.0, 1111));

    List<Bank> banks = new ArrayList<>();
    banks.add(bos);

    Atm atm = new Atm(banks);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome to Stefanos' ATM!");

    // Prompt for account number and prin
    System.out.println("Enter your account number");
    int accNo = scanner.nextInt();
    System.out.println("Enter your pin");
    int pin = scanner.nextInt();

    // Authenticate user and display menu
    atm.processTransaction(accNo, pin, scanner);

    scanner.close();
  }
}
