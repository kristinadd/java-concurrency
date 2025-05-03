package RaceCondition;

public class BankAccount {
  private double balance;

  public BankAccount() {
    balance = 0;
  }

  public synchronized void deposit(double amount) {
    balance += amount;
  }

  public synchronized void withdraw(double amount) {
    balance -= amount;
  }

  public synchronized double getBalance() {
    return balance;
  }
}
