package wlg.javaapi.thread;

public class ConcurrentThread {

  public volatile boolean flag = false;



  private void concurrentRun() throws Exception {
    long start = System.currentTimeMillis();
    ThreadGroup tg = new ThreadGroup("十面埋伏");
    for (int i = 0; i < 10; i++) {
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

  }

  private void task() {
    System.out.println("thread name:" + Thread.currentThread().getName()
                       + " "
                       + System.currentTimeMillis());
  }

  public static void main(String[] args) throws Exception {
    ConcurrentThread th = new ConcurrentThread();
    th.concurrentRun();
  }
}
