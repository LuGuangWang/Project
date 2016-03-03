package wlg.javaapi.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetTest {
  /**
   * 
   */
  static void testMultipleElement(){
    List<String> arr = Arrays.asList("1","1","2");
    Set<String> set = new HashSet<>(arr);
//    set.add("1");
//    set.add("1");
//    set.addAll(arr);
    List<String> arrnew = new ArrayList<String>(set);
    
    for(String s:set){
      System.out.println("set element: "+s);
    }
    for(String e:arrnew){
      System.out.println("list element: "+e);
    }
  }
  
  
  public static void main(String[] args) {
    testMultipleElement();
  }

}
