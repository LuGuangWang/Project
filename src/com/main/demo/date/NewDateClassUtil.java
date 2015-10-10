package com.main.demo.date;

import java.text.ParseException;
import java.time.LocalDate;

public class NewDateClassUtil {

  public static void testNewDate(){
    LocalDate localDate = LocalDate.now();
    System.out.println(localDate);
  }
  /**
   * 获取日期
   */
  public static void testFormatDate() throws ParseException{
    String datetime = "2015-08-11";
    LocalDate localDate = LocalDate.parse(datetime);
    LocalDate localDate2 = localDate.minusDays(1L);
    System.out.println(localDate2.isAfter(localDate));
    System.out.println(localDate.getDayOfWeek().getValue());
  }
  
  /**
   * 格式化日期
   */
  public static void testFormat(){
    System.out.println("testFormat()---------");
    String datetime = "2015-08-01";
    System.out.println(datetime.length());
    if(datetime.matches("\\d{4}-\\d{1}-\\d{1}")){
      datetime = datetime.replaceAll("-", "-0");
    }else if(datetime.matches("\\d{4}-\\d{1}-\\d{2}")){
      datetime = datetime.replaceFirst("-", "-0");
    }else if(datetime.matches("\\d{4}-\\d{2}-\\d{1}")){
      datetime = datetime.substring(0, datetime.length()-1) + "0" + datetime.charAt(datetime.length()-1);
    }
    System.out.println(datetime);
  }
  
  public static void main(String[] args) throws ParseException {
    testNewDate();
    testFormatDate();
    testFormat();
  }

}
