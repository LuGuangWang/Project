package wlg.test;

public class MutilpleThreadTest {
  private static MutilpleThreadTest instance = null;
  private MutilpleThreadTest(){}
  public static MutilpleThreadTest $(){
    if(instance == null){
      System.out.println("1 "+Thread.currentThread().getName());
      synchronized(MutilpleThreadTest.class){
        if(instance==null){
          System.out.println("2 "+Thread.currentThread().getName());
          instance = new MutilpleThreadTest();
        }
      }
    }
    return instance;
  }
  
  public static void main(String[] args) {
    for(int i=0;i<5;i++){
      new Thread(()->{
        System.out.println(MutilpleThreadTest.$());
      }).start();
    }
    for(int i=0;i<2;i++){
      new Thread(()->{
       System.out.println(MutilpleThreadTest.$());
      }).start();
    }
    for(int i=0;i<5;i++){
      new Thread(()->{
        System.out.println(MutilpleThreadTest.$());
      }).start();
    }
    for(int i=0;i<6;i++){
      new Thread(()->{
        System.out.println(MutilpleThreadTest.$());
      }).start();
    }
    for(int i=0;i<2;i++){
      new Thread(()->{
        System.out.println(MutilpleThreadTest.$());
      }).start();
    }
    for(int i=0;i<7;i++){
      new Thread(()->{
        System.out.println(MutilpleThreadTest.$());
      }).start();
    }
    for(int i=0;i<2;i++){
      new Thread(()->{
        System.out.println(MutilpleThreadTest.$());
      }).start();
    }
    for(int i=0;i<3;i++){
      new Thread(()->{
        System.out.println(MutilpleThreadTest.$());
      }).start();
    }for(int i=0;i<5;i++){
      new Thread(()->{
        System.out.println(MutilpleThreadTest.$());
      }).start();
    }
    for(int i=0;i<2;i++){
      new Thread(()->{
       System.out.println(MutilpleThreadTest.$());
      }).start();
    }
    for(int i=0;i<5;i++){
      new Thread(()->{
        System.out.println(MutilpleThreadTest.$());
      }).start();
    }
    for(int i=0;i<6;i++){
      new Thread(()->{
        System.out.println(MutilpleThreadTest.$());
      }).start();
    }
    for(int i=0;i<2;i++){
      new Thread(()->{
        System.out.println(MutilpleThreadTest.$());
      }).start();
    }
    for(int i=0;i<7;i++){
      new Thread(()->{
        System.out.println(MutilpleThreadTest.$());
      }).start();
    }
    for(int i=0;i<2;i++){
      new Thread(()->{
        System.out.println(MutilpleThreadTest.$());
      }).start();
    }
    for(int i=0;i<3;i++){
      new Thread(()->{
        System.out.println(MutilpleThreadTest.$());
      }).start();
    }
  }
}
