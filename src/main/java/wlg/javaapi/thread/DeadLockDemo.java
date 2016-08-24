package wlg.javaapi.thread;

public class DeadLockDemo {

  private static String A = "A";
  private static String B = "B";
  
  public static void main(String[] args) {
    new DeadLockDemo().deadLock();
  }
  
  private void deadLock(){
    Thread t1 = new Thread(()->{
      synchronized(A){
        try{
          Thread.sleep(2000);
        }catch(InterruptedException e){
          e.printStackTrace();
        }
        synchronized(B){
          System.out.println("1");
        }
      }
    },"thead-one");
    
    Thread t2 = new Thread(()->{
      synchronized(B){
        synchronized(A){
          System.out.println("2");
        }
      }
    },"thead-two");
    
    t1.start();
    t2.start();
  }

}
