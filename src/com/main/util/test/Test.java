package com.main.util.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test{
  Test(){}
  
  
  
  public static int testCompareTime(){
    String time1 = "2015-07-01 11:00:00";
    String time2 = "2015-07-09 11:00:00";
    return time2.compareTo(time1);
  }
  
  public static void testSplit(){
    String a = "A__C_D_";
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
  
  public static void main(String[] args) throws Exception{
    System.out.println(testCompareTime());
    testSplit();
//    System.out.println("this is my fisrt github source code.");
//    MyInterface in = new Interface2();
//    in.test();
//    
    
//    
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
	  
	  
//	  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//	  Calendar cal = Calendar.getInstance();
//	  cal.setTime(df.parse(df.format(new Date())));
//	  cal.add(Calendar.DATE, -60);
//	  System.out.println(df.format(cal.getTime()));
//	  
//	  int year = Calendar.getInstance().get(Calendar.YEAR);
//	  System.out.println(year);
	  
	  
	  String str = "尖1子1尖1子2目标";
	  System.out.println(str.contains("尖子"));
	  System.out.println(str.contains("目标"));
	  
	  
	  
  }
}
