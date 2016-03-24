package wlg.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.common.base.Strings;

public class Test{
  Test(){}
  
  public static int testCompareTime(){
    String time1 = "2015-07-01 11:00:00";
    String time2 = "2015-07-09 11:00:00";
    return time2.compareTo(time1);
  }
  
  public static void parseDays(String dates) throws ParseException{
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Calendar cal = Calendar.getInstance();
    cal.setTime(df.parse("2015-08-20"));
    System.out.println(df.format(cal.getTime()));
  }
  //字符串中是否包含数字
  public static boolean containDigit(String str){
    if(Strings.isNullOrEmpty(str))
      return false;
    return !str.matches("[^0-9]{1,}");
  }
  
  //判断是否全是数字
  public static boolean isDigit(String str){
    if(Strings.isNullOrEmpty(str))
      return false;
    return str.matches("^[0-9]{1,}");
  }
  
  //替换全部的.000
  public static void replaceStr(String str){
    str = str.replaceFirst("\\.0+$", "");
    System.out.println(str);
  }
  
  public static void replaceHanziStr(String str){
    str = str.replaceFirst("^[^0-9]{1,}", "");
    System.out.println(str);
  }
  
  
  public static void testSplit(){
    String a = "A_C_D_";
    String[] strs = a.split("_");
    for(String str :strs)
      System.out.println(str+" size:"+strs.length);
  }
  
  public static void testCalendar() throws ParseException{
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Calendar cal = Calendar.getInstance();
    cal.setTime(df.parse(df.format(new Date())));
    int currentMonth = cal.get(Calendar.MONTH)+1;
    
    if (currentMonth >= 1 && currentMonth <= 3) {

    } else if (currentMonth >= 4 && currentMonth <= 6) {
         
      } else if (currentMonth >= 7 && currentMonth <= 9) {
          
      } else if (currentMonth >= 10 && currentMonth <= 12) {
         
      } 
    
    System.out.println();
  }
  /**
   * 测试数组中是否含有数据
   */
  public static void testContain(){
    List<Integer> ins = new ArrayList<>();
    Integer a = 1;
    ins.add(1);
    System.out.println("testContain:"+ins.contains(a));
    
    List<String> strs = new ArrayList<>();
    String ass = "1";
    strs.add("1");
    System.out.println("testContain:"+strs.contains(ass));
    
    Integer[] as = {1,2};
    List<Integer> asl = Arrays.asList(as);
    System.out.println("testContain:"+asl.contains("2"));
  }
  
  
  private static void testListSize(){
    List<String> strs = new ArrayList<String>(4);
    strs.add("1");
    System.out.println("array size:"+strs.size());
  }
  
  public static void testIntParam(int i){
    System.out.println("testIntParam():"+i);
  }
  
  public void setMock(String arg){
    arg.toString();
  }
  
  public static void main(String[] args) throws Exception{
    int i=2;
    testIntParam(i++);
    System.out.println("----:"+i);
      
    String str2 = "";
    System.out.println(str2+",2");
    
    replaceHanziStr("每周六日8：00-10:00,13:00-15:00；周一10:30-12:00，13:00-15:00");
    
    testListSize();
    
    System.out.println(String.valueOf(System.currentTimeMillis()-1443148421988L));
    
    
    replaceStr("1.000000");

    testContain();
    
    System.out.println("是否都是数字："+isDigit("1232131")+" 是否含有数字："+containDigit("1232131哈"));
    
    String str = "尖1子1尖1子2目标";
    System.out.println(str.contains("尖子"));
    System.out.println(str.contains("目标"));
    
    System.out.println(testCompareTime());
    testSplit();
//    System.out.println("this is my fisrt github source code.");
//    MyInterface in = new Interface2();
//    in.test();
    
//    String time = "2015-01-01";
//    int length = time.length();
//    System.out.println(time + " " + length + " "+ (time.length()==10));
//    
//    if(time.length()>10){
//    	time = time.substring(0,10)+" 23:59:59";
//    }
//    else{
//    	time += " 23:59:59";
//    }
//    length = time.length();
//    System.out.println(time + " " + length);
	  
//	  int year = Calendar.getInstance().get(Calendar.YEAR);
//	  System.out.println(year);
  }
}
