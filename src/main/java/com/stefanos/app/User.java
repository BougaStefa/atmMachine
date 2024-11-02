package com.stefanos.app;

public class User {
  private int accNo;
  private double balance;
  private int pin;

  public User(int accNo, double balance, int pin) {
    this.accNo = accNo;
    this.balance = balance;
    this.pin = pin;
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

  public void deposit(double amount) {
    balance += amount;
  }

  public void withdraw(double amount) {
    balance -= amount;
  }
}
