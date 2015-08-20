/**
 * 
 */
package com.main.demo.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.google.common.base.Strings;

/**
 * 时间的一些使用
 * @author WLG
 *
 */
public class DateUtil {
	DateUtil(){
		
	}
	/**
	 * 获取当前系统前一天日期
	 * @param date
	 * @return
	 */
    public static Date getPreviousDay(Date date) {  
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        calendar.add(Calendar.DAY_OF_MONTH, -3);  
        date = calendar.getTime();  
        return date;  
    }  
    
    /**
     * 获取当前系统日期
     * @param date
     * @return
     */
    public static Date getCurrentDay(Date date) {  
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        calendar.add(Calendar.DAY_OF_MONTH, 0);  
        date = calendar.getTime();  
        return date;  
    }  
    
    /**
     * 获取当前系统下一天日期
     * @param date
     * @return
     */
    public static Date getNextDay(Date date) {  
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        calendar.add(Calendar.DAY_OF_MONTH, 1);  
        date = calendar.getTime();  
        return date;  
    }  
    
    public static Date roundToSeconds(Date date) {
    	return new Date(date.getTime() / 1000L * 1000L);
    }
    /**
     * 获取到秒
     * @return
     */
    public static Date curDate() {
    	return roundToSeconds(new Date());
    }
    /**
     * 解析一段时间内的日期和星期
     */
    public static void parseDays(String dateFrom,String dateTo) throws ParseException{
      if(Strings.isNullOrEmpty(dateFrom) || Strings.isNullOrEmpty(dateTo) || dateFrom.compareTo(dateTo)>0)
        throw new RuntimeException("传入参数不符合要求");
      
      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
      Calendar calFrom = Calendar.getInstance();
      Calendar calTo = Calendar.getInstance();
      
      calFrom.setTime(df.parse(dateFrom));
      calTo.setTime(df.parse(dateTo));
      do{
        System.out.println("weekDay:"+calFrom.getTime());
        System.out.println("weekDay:"+calFrom.get(Calendar.DAY_OF_WEEK));
        
        calFrom.add(Calendar.DAY_OF_MONTH, 1);
      }while(!calFrom.after(calTo));
    }
    
    public static void main(String[] args) throws ParseException{
      parseDays("2015-08-16","2015-08-20");
      
      
      
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    	Date date = DateUtil.getCurrentDay(new Date());
    	System.out.println(df.format(date));
    	
    	date = DateUtil.getPreviousDay(new Date());
    	System.out.println(df.format(date));
    	
    	date = DateUtil.getNextDay(new Date());
    	System.out.println(df.format(date));
    	
    	System.out.println(DateUtil.curDate());
    	
    }
}
