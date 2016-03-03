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
	  clear();
	  
		Bean b = new Bean();
		b.setTest("test");
		List<Bean> beans = new ArrayList<Bean>();
		beans.add(b);
		b.setTest("t");//属性的更改，会影响list里德对象值
		b=null;//不会影响已add到list里的内容
		System.out.println(beans.get(0).toString());
		
		
		List<List<Bean>> beanList = new ArrayList<List<Bean>>();
		System.out.println("beans:"+beans.toString());
		beanList.add(beans);
		beans.clear();
		System.out.println("beanList:"+beanList.toString());
	}

}
