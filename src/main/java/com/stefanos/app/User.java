package com.stefanos.app;

public class User {
  private int accNo;
  private double balance;
  private int pin;
  private String name;
  private String surname;

  public User(int accNo, double balance, int pin, String name, String surname) {
    this.accNo = accNo;
    this.balance = balance;
    this.pin = pin;
    this.name = name;
    this.surname = surname;
  }

  public int getAccNo() {
    return accNo;
  }

  public int getPin() {
    return pin;
  }

  public double getBalance() {
    return balance;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public void deposit(double amount) {
    balance += amount;
  }

  public void withdraw(double amount) {
    balance -= amount;
  }
}
