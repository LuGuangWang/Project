package wlg.javaapi.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CountDownLatchDemo {

  public static void main(String[] args) {
//    Driver d = new Driver();
//    try {
//      d.main();
//    } catch (InterruptedException e) {
//    }
    
    Driver2 d2 = new Driver2();
    try {
      d2.main();
    } catch (InterruptedException e) {
    }
  }

}
/**** demo one begin ****/
class Driver { // ...
  void main() throws InterruptedException {
    int N = 10;
    
    CountDownLatch startSignal = new CountDownLatch(1);
    CountDownLatch doneSignal = new CountDownLatch(N);

    for (int i = 0; i < N; ++i) // create and start threads
      new Thread(new Worker(startSignal, doneSignal)).start();

    doSomethingElse();            // don't let run yet
    startSignal.countDown();      // let all threads proceed
    doSomethingElse();
    doneSignal.await();           // wait for all to finish
  }

  private void doSomethingElse() {
    System.out.println("do some thing else.=="+System.currentTimeMillis());
  }
}

class Worker implements Runnable {
  private final CountDownLatch startSignal;
  private final CountDownLatch doneSignal;
  Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
    this.startSignal = startSignal;
    this.doneSignal = doneSignal;
  }
  public void run() {
    try {
      startSignal.await();
      doWork();
      doneSignal.countDown();
    } catch (InterruptedException ex) {} // return;
  }

  void doWork() {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
    }
    System.out.println("do work.=="+System.currentTimeMillis());
  }
} 
/**** demo one end ****/

/**** demo two begin ****/
class Driver2 { // ...
  void main() throws InterruptedException {
    int N = 10;
    CountDownLatch doneSignal = new CountDownLatch(N);
    ThreadPoolExecutor e = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

    for (int i = 0; i < N; ++i) // create and start threads
      e.execute(new WorkerRunnable(doneSignal, i));

    doneSignal.await();           // wait for all to finish
    e.shutdownNow();
  }
}

class WorkerRunnable implements Runnable {
  private final CountDownLatch doneSignal;
  private final int i;
  WorkerRunnable(CountDownLatch doneSignal, int i) {
    this.doneSignal = doneSignal;
    this.i = i;
  }
  public void run() {
    doWork(i);
    doneSignal.countDown();
  }

  void doWork(int i) { 
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
    }
    System.out.println("do work.== "+i+" =="+System.currentTimeMillis());
  }
}
/**** demo two end ****/