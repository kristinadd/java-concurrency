package RaceCondition;

public class Main {
  public static void main(String[] args) {

    BankAccount account1 = new BankAccount();

    Thread t1 = new Thread(() -> {
      for (int i = 0; i < 3; i++) {
        account1.deposit(100);
        System.out.println("🔴 Deposit: " + account1.getBalance());
      }
    });

    Thread t2 = new Thread(() -> {
      for (int i = 0; i < 3; i++) {
        account1.withdraw(100);
        System.out.println("🔴 Withdraw : " + account1.getBalance());
      }
    });

    t1.start();
    t2.start();
  }
}
