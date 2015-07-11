/**
 * 
 */
package com.main.demo.data;

import java.math.BigDecimal;

/**
 * 自然数的使用
 * @author WLG
 *
 */
public class DataUtil {
	/**
	 * 四舍五入 转为2位小数
	 * @param teacherRate
	 * @return
	 */
	public Double doubleScale(Double teacherRate){
		BigDecimal b = new BigDecimal(teacherRate);  
		return b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public static void main(String[] args){
		DataUtil instance = new DataUtil();
		System.out.println(instance.doubleScale(2.33534));
	}
}
