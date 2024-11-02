package com.stefanos.app;

import java.util.List;

public class Atm {
  private List<Bank> banks;

  public Atm(List<Bank> banks) {
    this.banks = banks;
  }

  public void processTransaction(int accNo, int pin) {
    String bankID = String.valueOf(accNo).substring(0, 2);
    Bank bank = getBankByID(bankID);

    if (bank != null) {
      User user = bank.getUser(accNo, pin);
      if (user != null) {
        System.out.println("Account " + accNo + " authenticated.");
        // OPERATION TO BE ADDED
        bank.updateUser(user);
      } else {
        System.out.println("Authentication failed.");
      }
    } else {
      System.out.println("Bank not supported.");
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
