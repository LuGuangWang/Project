package wlg.test;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class NewTest {
  
  public static void main(String[] args){
//    testOperator();
//    testLength();
//    testIntegerMethod();
//    testInstanceof();
//    testReturn();
//    testSpring();
//    format();
//    isn(5);
    
  }
  
  
  
  static int[] twoSum1(int[] nums, int target) {
    Map<Integer, Integer> nMap = new HashMap<>(nums.length);
    for (int i = 1; i < nums.length; i++) {
      nMap.put(nums[i - 1], i - 1);
      if (nMap.containsKey(target - nums[i])) {
        return new int[] {nMap.get(target - nums[i]), i};
      }
      if (nMap.containsKey(target - nums[nums.length-i])) {
        return new int[] {nMap.get(target - nums[nums.length-i]), nums.length-i};
      }
    }
    throw new IllegalArgumentException("No two sum solution");
  }
  
  static void isn(int n){
    float a = n;
    if(a==1){
      System.out.println("===>"+a);
    }else{
      while(true){
        a /= 2;
        if(a==1 || a != ((int) a)){
          break;
        }
      }
      if(a==1){
        System.out.println("isn ====>>"+n);
      }
    }
  }
  
  static void format(){
    String str = "2016年1月1日";
    String dateRegex = "\\d+[\\.|年|-]\\d+[\\.|月|-]\\d+日{0,1}";
    System.out.println(str.matches(dateRegex));
  }
  
  static void testSpring(){
    int size = 100;
    int startSize = 100;
    System.out.println(startSize + (startSize>>2));
    while(startSize + (startSize>>2) > size){
      size <<= 1;
      System.out.println("testSpring:"+size);
    }
  }
  
  //测试操作符
  static void testOperator(){
    int x,y;
    x=y=1;
    System.out.print("x:"+x + " y:"+y);
  }
  
  static void testInstanceof(){
    boolean flag = null instanceof String;
    System.out.println(flag);
  }
  
  //测试return
  static void testReturn(){
    return;
//    System.out.print("Hello");//return 语句后写东西是校验不过的
  }
  
  static void testLength(){
    String name = "优能E计划听力口语集训营（初三预科原酷学酷玩听口）";
    try {
      System.out.println("str length:" + name.getBytes("gbk").length);
    } catch (UnsupportedEncodingException e) {
      
    } 
  }
  
  static void testIntegerMethod() {
    int number = 1;
    System.out.println(Integer.toBinaryString(number));
    System.out.println(Integer.numberOfTrailingZeros(number));
    System.out.println(Integer.numberOfLeadingZeros(number));
    System.out.println(">>>>>>>>>" + (number >> 1));
    System.out.println(number >>> 2);
    System.out.println(~number);
    System.out.println(~number);
  }
}
