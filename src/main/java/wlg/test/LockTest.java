package wlg.test;

public class LockTest {

  static LockTest instance = new LockTest();

  private Integer count = 1;
  
  private void print() {
    synchronized(instance){
      count ++;
      System.out.println(Thread.currentThread().getName());
    }
  }

  private synchronized void println() {
      System.out.println(Thread.currentThread().getName() + ". count " + count);
      try {
        Thread.sleep(1500);
      } catch (InterruptedException e) {
      }
  }

  public static void main(String[] args) {
    for (int i = 0; i <= 10; i++) {
      new Thread(() -> {
        instance.print();
      }, "thread-test-" + i).start();
      new Thread(() -> {
        instance.println();
      }, "thread-print-" + i).start();
    }
  }
}
