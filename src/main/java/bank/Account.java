package bank;

import bank.exception.AmountException;

public class Account {
  private int id;
  private String type;
  private Double balance;

  public Account(int id, String type, Double balance) {
    this.id = id;
    this.type = type;
    this.balance = balance;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Double getBalance() {
    return this.balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  public void deposit(Double amount) throws AmountException {
    if (amount < 1) {
      throw new AmountException("The minimum deposit is 1.00");
    } else {
      double newBalance = balance + amount;
      setBalance(newBalance);
      DataSource.updateAccountBalance(id, newBalance);
    }

  }

  public void withdraw(Double amount) throws AmountException {
    if (amount < 0) {
      throw new AmountException("The withdrawal amount must be greater than 0");
    } else if (amount > getBalance()) {
      throw new AmountException("You do not have sufficient funds for this withdrawal.");
    } else {
      double newBalance = balance - amount;
      setBalance(newBalance);
      DataSource.updateAccountBalance(id, newBalance);
    }

  }

}
