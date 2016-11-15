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
    
    String num1 = "919";
    String num2 = "13";
    String sum = addStrings(num1, num2);
    System.out.println(sum);
    
    float a = 0.1f;
    float b = 0.1f;
    float c = a*1000*b*1000/1000/1000;
    System.out.println(c);
//    int[] nums = {1, 5, 11, 5};
//    System.out.println(canPartition(nums));
    
    
  }
  
  
  
//  public static boolean canPartition(int[] nums) {
//    boolean flag = false;
//    if(nums != null && nums.length>0){
//      Map<Integer,Integer> sorted = new TreeMap<>();
//      int sum = 0;
//      for(int i = 0;i<nums.length;i++){
//        sum += nums[i];
//        sorted.put(nums[i], i);
//      }
//      for(int i = nums.length-1;i>=0;i--){
//        sum - sorted.;
//      }
//      
//    }else{
//      
//    }
//    
//    
//    return flag;
//  }
  
  public static String addStrings(String num1, String num2) {
    if(num1!=null && num2!=null){
      int slen=0,sum=0,flag = 0,carry=0;
      if(num1.length()>num2.length()){
        slen = num2.length();
        flag = 1;
      }else{
        slen = num1.length();
      }
      StringBuilder result = new StringBuilder(0);
      for(int i=1;i<=slen;i++){
        sum = carry + num1.charAt(num1.length()-i)-'0' + num2.charAt(num2.length()-i)-'0';
        if(sum-10>=0){
          result.insert(0, sum-10);
          carry = 1;
        }else{
          carry = 0;
          result.insert(0, sum);
        }
      }
      if(flag == 1){//num1还有剩余
        for(int i = num1.length()-slen-1;i>=0;i--){
          sum = num1.charAt(i)-'0' + carry;
          if(sum-10>=0){
            result.insert(0, sum-10);
            carry = 1;
          }else{
            result.insert(0, sum);
            carry = 0;
          }
        }
      }else{
        for(int i = num2.length()-slen-1;i>=0;i--){
          sum = num2.charAt(i)-'0' + carry;
          if(sum-10>=0){
            result.insert(0, sum-10);
            carry = 1;
          }else{
            result.insert(0, sum);
            carry = 0;
          }
        }
      }
      if(carry==1){
        result.insert(0, 1);
      }
      return result.toString();
    }else{
      return num1==null?num2:num1;
    }
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
