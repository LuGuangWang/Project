package wlg.test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NewTest2 {
  
  public static void main(String[] args) {
	  int size = -Math.floorDiv(0, 5);
	  System.out.println("size:" + size);
	  
	  
	  
	  
	  
//    System.out.println(testReturn());
    List<Integer> arr= Arrays.asList(1,2,3,4,1,6,7,8,9);
    arr.sort((a,b)->b-a);
    System.out.println(count(arr,1));
//    testCycle();
  }
  
  private static int count(List<Integer> arr, int pai) {
		int count = 0;
		for(int i=arr.size()-1;i>=0;i--) {
			if(arr.get(i)==pai) {
				count++;
			}else {
				break;
			}
		}
		return count;
	}

  static int testReturn() {
    int s = 1;
    try{
      return s;
    }finally{
      s = 2;
    }
  }

  static void testCycle() {
    for(int i = 0;i<3;i++){
      while(i<2){
        System.out.println("j:" + i);
        break;
      }
      System.out.println("i:" + i);
    }
  }
}
