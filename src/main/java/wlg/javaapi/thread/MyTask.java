package wlg.javaapi.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class MyTask {
  
  ReentrantLock lock = new ReentrantLock();
  
  public Map<String, Integer> map = new HashMap<String, Integer>();

  public MyTask(){
    map.put("1", 0);
  }
  
  public void add(String key){
      lock.lock();
      try{
//    synchronized(map){
        Integer val = map.get(key);
        map.put(key, val+1);
//    }
      }finally{
        lock.unlock();
      }
    }
  
}
