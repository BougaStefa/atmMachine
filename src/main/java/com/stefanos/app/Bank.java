package com.stefanos.app;

import java.util.ArrayList;
import java.util.List;

public class Bank {
  private String bankID;
  private List<User> users;

  public Bank(String bankID) {
    this.bankID = bankID;
    this.users = new ArrayList<>();
  }

  public void addUser(User user) {
    users.add(user);
  }

  public User getUser(int accNo, int pin) {
    for (User user : users) {
      if (user.getAccNo() == accNo && user.getPin() == pin) {
        return user;
      }
    }
    return null;
  }

  public void updateUser(User user) {
    System.out.println("User data updated for account: " + user.getAccNo());
  }

  public String getBankID() {
    return bankID;
  }
}
