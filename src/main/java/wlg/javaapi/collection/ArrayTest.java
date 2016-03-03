package wlg.javaapi.collection;

import java.util.Arrays;
import java.util.List;

public class ArrayTest {

  static void testContains(){
    List<String> arr = Arrays.asList("hello","world");
    System.out.println(arr.contains("hello"));
  }
  
  public static void main(String[] args) {
    testContains();
  }
  
}
