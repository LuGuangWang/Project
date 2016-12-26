package wlg.javaapi.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Util {
  public static void sleep(int seconds) {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}


class Call implements Callable<String> {
  // This simulates the query to database
  @Override
  public String call() throws Exception {
    Util.sleep(20);
    return "data";
  }
}


public class FutureUtil {

  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(1);
    Call call = new Call();
    Future<String> future = (Future<String>) executor.submit(call);

    int i = 0;
    for (;;) {
      Util.sleep(5);
      if (future.isDone())
        try {
          executor.shutdown();
          System.out.println(future.get());
          return;
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      else
        System.out.println("i: " + ++i);
    }
  }

}
