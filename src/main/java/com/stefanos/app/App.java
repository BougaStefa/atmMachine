package com.stefanos.app;

import java.util.List;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    Bank bos = new Bank("10");
    bos.addUser(new User(101, 500.00, 1234));
    bos.addUser(new User(102, 600.00, 1245));

    Bank loyds = new Bank("20");
    loyds.addUser(new User(201, 699.69, 8008));

    List<Bank> banks = new ArrayList<>();
    banks.add(bos);
    banks.add(loyds);
    Atm atm = new Atm(banks);

    atm.processTransaction(101, 1234);
    atm.processTransaction(201, 8008);
  }
}
