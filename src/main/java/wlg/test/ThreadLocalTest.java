package wlg.test;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalTest {
  private static volatile ThreadLocalTest instance = null;
  private ThreadLocalTest(){}
  public static ThreadLocalTest $(){
    if(instance == null){
      synchronized(ThreadLocalTest.class){
        instance = new ThreadLocalTest();
      }
    }
    return instance;
  }
  private ThreadLocal<Map<String,Object>> map = null;
  
  public synchronized void init(){
    System.out.println(Thread.currentThread().getName());
    map = new ThreadLocal<Map<String,Object>>(){
      @Override
      protected Map<String, Object> initialValue() {
        return new HashMap<>();
      }
    };
  }
  
  public synchronized ThreadLocal<Map<String, Object>> getMap() {
    return map;
  }
  public synchronized void setMap(ThreadLocal<Map<String, Object>> map) {
    this.map = map;
  }
  
  public static void main(String[] args) {
    ThreadLocalTest instance = ThreadLocalTest.$();
    Thread t  = new Thread(()->{
//      ThreadLocalTest instance = new ThreadLocalTest();
      System.out.println("1 ==");
      instance.init();
      instance.getMap().get().put("w", 1);
      System.out.println("1 =="+instance.getMap().get());
      try {
        Thread.sleep(1000);
      } catch (Exception e) {
      }
      instance.getMap().get().put("w", 2);
      System.out.println("2 =="+instance.getMap().get());
    });
    Thread t1  = new Thread(()->{
//      ThreadLocalTest instance = new ThreadLocalTest();
      System.out.println("3 ==");
      instance.init();
      instance.getMap().get().put("w", 3);
      System.out.println("3 =="+instance.getMap().get());
      try {
        Thread.sleep(2000);
      } catch (Exception e) {
      }
      instance.getMap().get().put("w", 4);
      System.out.println("4 =="+instance.getMap().get());
    });
    Thread t2  = new Thread(()->{
//      ThreadLocalTest instance = new ThreadLocalTest();
      instance.init();
      instance.getMap().get().put("w", 7);
      System.out.println("7 =="+instance.getMap().get());
      try {
        Thread.sleep(1000);
      } catch (Exception e) {
      }
      instance.getMap().get().put("w", 8);
      System.out.println("8 =="+instance.getMap().get());
    });
    Thread t3  = new Thread(()->{
//    ThreadLocalTest instance = new ThreadLocalTest();
    instance.init();
    instance.getMap().get().put("w", 9);
    System.out.println("9 =="+instance.getMap().get());
    try {
      Thread.sleep(3000);
    } catch (Exception e) {
    }
    instance.getMap().get().put("w", 10);
    System.out.println("10 =="+instance.getMap().get());
  });
    t.start();
    t1.start();
    t2.start();
    t3.start();
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
    }
//    System.out.println("5 =="+instance.getMap().get());
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
    }
//    System.out.println("6 =="+instance.getMap().get());
  }
}
