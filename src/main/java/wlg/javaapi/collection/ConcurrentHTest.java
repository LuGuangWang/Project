package wlg.javaapi.collection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHTest {

  private static Map<String,String> map = new ConcurrentHashMap<>(2);
  
  static{
    String tmp;
    for(int i=1;i<80;i++){
      tmp = String.valueOf(i);
      map.put(tmp,tmp);
    }
  }
  
  public static void main(String[] args) {
    
  }
}
