public class ThreadTest {
  private static final int N_ACCOUNTS     = 4;
  private static final double INITIAL_BAL = 100_000;
  private static final int STEPS          = 10;
  private static final double MAX_AMOUNT  = 1_000;
  private static final int DELAY          = 10;  // max sleep time (ms)

  public static void main(String[] args) {
      Bank bank = new Bank(N_ACCOUNTS, INITIAL_BAL);

      // Thread 1: transfer between account 0 → 1
      Runnable r1 = () -> {
          try {
              for (int i = 0; i < STEPS; i++) {
                  double amount = MAX_AMOUNT * Math.random();
                  bank.transfer(0, 1, amount);
                  Thread.sleep((int) (DELAY * Math.random()));
              }
          } catch (InterruptedException e) {
              // exit if interrupted
          }
      };
      new Thread(r1).start();

      // Thread 2: transfer between account 2 → 3
      Runnable r2 = () -> {
          try {
              for (int i = 0; i < STEPS; i++) {
                  double amount = MAX_AMOUNT * Math.random();
                  bank.transfer(2, 3, amount);
                  Thread.sleep((int) (DELAY * Math.random()));
              }
          } catch (InterruptedException e) {
              // exit if interrupted
          }
      };
      new Thread(r2).start();
  }
}
