package wlg.test;

import java.io.UnsupportedEncodingException;

public class NewTest {
  
  public static void main(String[] args){
    testOperator();
    testLength();
    testIntegerMethod();
    testInstanceof();
    testReturn();
    testSpring();
  }
  
  static void testSpring(){
    System.out.println(Test.class.getPackage().getImplementationVersion());
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
  
  private static void testIntegerMethod() {
    int number = 2;
    System.out.println(Integer.toBinaryString(number));
    System.out.println(Integer.numberOfTrailingZeros(number));
    System.out.println(Integer.numberOfLeadingZeros(number));
    System.out.println(number >> 3);
    System.out.println(number >>> 2);
    System.out.println(~number);
    System.out.println(~number);
  }
}
