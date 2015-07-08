/**
 * 
 */
package com.main.demo.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
        calendar.add(Calendar.DAY_OF_MONTH, -1);  
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
    
    public static void main(String[] args){
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    	Date date = DateUtil.getCurrentDay(new Date());
    	System.out.println(df.format(date));
    	
    	date = DateUtil.getPreviousDay(new Date());
    	System.out.println(df.format(date));
    	
    	date = DateUtil.getNextDay(new Date());
    	System.out.println(df.format(date));
    }
}
