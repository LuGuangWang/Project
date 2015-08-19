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
  
  public static void main(String[] args) throws ParseException {
    testNewDate();
    testFormatDate();
  }

}
