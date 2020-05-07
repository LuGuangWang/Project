package wlg.test;

import java.util.LinkedHashMap;

public class Test implements Runnable {

  private volatile int inc = 0;
  private void increase() {
    inc++;

    System.out.println(Thread.currentThread().getName() + " : " + inc);
  }

  public void run() {
    increase();
  }

  public static void main (String[] args) {
    for(int i=0;i<10;i++){
      Test test = new Test();
      new Thread(test).start();

      test.increase();
      Thread.yield();
      System.out.println(test.inc);

      System.out.println("==========");

    }

  }
}