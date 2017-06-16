package wlg.javaapi.thread;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadException {

  public static void main(String[] args) {
    ThreadException instance = new ThreadException();
    instance.catchExceptionByHandler();
    // 通过future处理异常
    catchExceptionByFuture();
  }


  void catchExceptionByHandler() {
    Thread thread = new Thread(() -> {
      System.out.println(3 / 2);
      System.out.println(3 / 0);
      System.out.println(3 / 1);
    });
    thread.setUncaughtExceptionHandler(new ExceptionHandler());
    thread.start();
  }

  class ExceptionHandler implements UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
      System.out.println("==Exception: " + e.getMessage());
    }
  }

  static void catchExceptionByFuture() {
    ExecutorService exec = Executors.newCachedThreadPool();
    Future<?> future = exec.submit(() -> {
      try {
        throw new Error("a error.");
      } catch (Exception e) {
        System.out.println("this thread exception " + e.getMessage());
      }
    });
    exec.shutdown();
    try {
      future.get();
    } catch (InterruptedException | ExecutionException e) {
      System.out.println("==Exception: " + e.getMessage());
    }
  }

}
