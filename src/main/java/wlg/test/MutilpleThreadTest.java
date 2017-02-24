package wlg.test;

import java.util.ArrayList;
import java.util.List;

public class MutilpleThreadTest {
  private static MutilpleThreadTest instance = null;
  private MutilpleThreadTest(){}
  public static MutilpleThreadTest $(){
    if(instance == null){
      synchronized(MutilpleThreadTest.class){
        if(instance==null){
          instance = new MutilpleThreadTest();
        }
      }
    }
    return instance;
  }
  
  int num = 0;
  boolean flag = false;
//  AtomicInteger num = new AtomicInteger(0);
//  void set(){
//    num = 2;
//  }
  
  int multipleRead(){
    if(flag){
      return 3 + num;
    }
    return num;
//    synchronized(this){
//      return num;
//    }
//    synchronized(num){
//      return num.intValue();
//    }
  }
  
  void multipleWrite(){
    flag = true;
    num = 1;
    
//    num ++;
    
//    synchronized(this){
//      num ++;
//    }
    
//    synchronized(num){
//      num.incrementAndGet();
//    }
  }
  
  
  public static void main(String[] args) {
    for(int i=0;i<20;i++){
      multiple2();
    }
//    multipleThread();
  }
  
  static void multiple2() {
    MutilpleThreadTest instance = MutilpleThreadTest.$();
    for(int i = 0;i<10;i++){
      instance.flag =false;
      new Thread(()->{
        instance.multipleWrite();
      }).start();
      
      new Thread(()->{
        int result = instance.multipleRead();
        System.out.println(result);
      }).start();
    }
  }
  
  static void multipleThread() {
    int size = 10000;
    MutilpleThreadTest instance = MutilpleThreadTest.$();
    List<Thread> multipleThread = new ArrayList<>(size);
    
    for(int i=0;i<size;i++){
      multipleThread.add(new Thread(()->{
        instance.multipleWrite();
      }));
    }
    
    for(Thread t:multipleThread){
      t.start();
    }
    for(int i=size-1;i>-1;i--){
      Thread t = multipleThread.remove(i);
      while(t.isAlive()){
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          System.out.println("error == " + e.getMessage());
        }
      }
    }
    System.out.println(MutilpleThreadTest.$().multipleRead());
  }
}
