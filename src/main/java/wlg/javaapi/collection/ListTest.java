package wlg.javaapi.collection;

import java.util.*;

public class ListTest {

  static void clear(){
    Bean b = new Bean();
    b.setTest("tst1");
    List<Bean> arr = new ArrayList<Bean>();
    arr.add(b);
    List<Bean> arr2 = new ArrayList<Bean>();
    arr2.addAll(arr);
    arr.clear();
    System.out.println("result:" + arr2);
  }
  
	public static void main(String[] args) {
	  	Map<String,String> params = new HashMap<>();
		params.remove("test");
	}

}
