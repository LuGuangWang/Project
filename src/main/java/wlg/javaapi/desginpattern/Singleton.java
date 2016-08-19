package wlg.javaapi.desginpattern;

/**
 * 单例模式
 */
public class Singleton {
  
  private static volatile Singleton instance = null;
  
  private Singleton(){
    
  }
  
  public static Singleton getInstance(){
    if(instance==null){
      synchronized(Singleton.class){
        instance = new Singleton();
      }
    }
    return instance;
  }
  
  public static void main(String[] args) {
    Singleton.getInstance();
    Singleton.getInstance();
    Singleton.getInstance();
  }
}
