package wlg.javaapi.demo.data;

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
	
	static void equals(){
	  Integer a = 1;
	  double b = 1.00;
	  System.out.println("is equal:" + (a==b));
	}
	
	public static void main(String[] args){
		DataUtil instance = new DataUtil();
		System.out.println(instance.doubleScale(2.33534));
		
		equals();
	}
}
