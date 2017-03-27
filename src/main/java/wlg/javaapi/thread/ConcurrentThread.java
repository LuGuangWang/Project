package wlg.javaapi.thread;

import java.util.Iterator;

public class ConcurrentThread {

  public volatile boolean flag = false;

  MyTask n = new MyTask();


  private void concurrentRun() throws Exception {
    long start = System.currentTimeMillis();
    ThreadGroup tg = new ThreadGroup("十面埋伏");
    for (int i = 0; i < 1000; i++) {
      Thread t = new Thread(tg, () -> {
        while (true) {
          if (flag) {
            task();
            break;
          }
        }
      });
      t.start();
    }
    
    flag=true;
    
    while (tg.activeCount()>=0) {
      if(tg.activeCount()==0){
        long end = System.currentTimeMillis();
        System.out.println("time :" + (end - start));
        break;
      }
    }
    System.out.println("========================");
    Iterator<String> it = n.map.keySet().iterator();
    while(it.hasNext()){
      String key = it.next();
      System.out.println("key：" + key + " value:" + n.map.get(key));
    }
  }

  private void task() {
    n.add("1");
//    System.out.println("thread name:" + Thread.currentThread().getName()
//                       + " "
//                       + System.currentTimeMillis());
  }

  public static void main(String[] args) throws Exception {
    for(int i=0;i<10;i++){
      ConcurrentThread th = new ConcurrentThread();
      th.concurrentRun();
    }
  }
}
