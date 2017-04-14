package wlg.test;
import java.io.File;
import java.io.FileWriter;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NewTest {
  
  
  class A{}
  
  
  
  public NewTest(){
    map.put("1", 0);
  }
  
  void test(){
    new NewTest().new A();
  }
 
  public static void replaceStr(String str){
    str = str.replaceAll("0+$", "");
    System.out.println(str);
  }
  /**
   * 1101.1 > 一千一百零一点一
   */
  public static String transfer(String numStr){
    StringBuilder result = new StringBuilder();
    String[] keyWord = {"零","一","二","三","四","五","六","七","八","九"};
    String[] unit = {"点","","十","百","千","万"};
    if(numStr != null){
      if(numStr.contains(".")){
        int spotIndex = numStr.indexOf("."),keyWordIndex;
        String numStr1 = numStr.substring(0,spotIndex);
        result.append(parseNumber(numStr1, keyWord, unit)).append(unit[0]);
        while(spotIndex<numStr.length()-1){
          keyWordIndex = Character.getNumericValue(numStr.charAt(++spotIndex));
          result.append(keyWord[keyWordIndex]);
        }
      }else{
        return parseNumber(numStr, keyWord, unit);
      }
    }
    return result.toString();
  }

  private static String parseNumber(String numStr, String[] keyWord,String[] unit) {
    StringBuilder result = new StringBuilder();
    int unitIndex = numStr.length(),keyWordIndex,len=0;
    while(len<numStr.length()){
      keyWordIndex = Character.getNumericValue(numStr.charAt(len++));
      if(keyWordIndex==0){
        result.append(keyWord[keyWordIndex]);
      }else{
        result.append(keyWord[keyWordIndex]+unit[unitIndex]);
      }
      unitIndex--;
    }
    return result.toString();
  }
  
  public static String findKey(String target,String keyWord) throws Exception{
    String path=null,tmp1= target,tmp2= target,result;
    int count = 0;
    
    if(target!=null && keyWord!=null){
      path = "D:/result.txt";
      try(FileWriter out = new FileWriter(new File(path));){
        do{
          tmp1 = tmp2;
          tmp2 = tmp1.replaceFirst(keyWord, "");
          count ++;
        }while(tmp2.length()<tmp1.length());
        result = "关键字" + keyWord + "在" + target +"出现次数为：" + (count-1);
        out.write(result);
      }
    }
    return path;
  }
  
  public Map<String, Integer> map = new ConcurrentHashMap<String, Integer>();

  public void add(String key){
    synchronized(map){
      Integer val = map.get(key);
      int newVal = val+1;
      map.put(key, newVal);
    }
  }
  
  public static void main(String[] args){
    System.out.println(Calendar.getInstance().get(Calendar.YEAR));
    
//    String result = transfer("1001.12");
//    System.out.println(result);
    
//    try {
//      findKey("absssd","ab");
//    } catch (Exception e) {
//      System.out.println(e);
//    }
//    replaceStr("200.0000");
//    testOperator();
//    testLength();
//    testIntegerMethod();
//    testInstanceof();
//    testReturn();
//    testSpring();
//    format();
//    isn(5);
    
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
