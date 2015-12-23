package com.main.demo.string;

public class StringUtil {

  //去除所有非汉字
  static void replaceChinese(){
    String str = "*%hell^你好12）（";
    str = str.replaceAll("[^\u4E00-\u9FA5]", "");
    System.out.println(str);
  }
  //是否是中文
  static boolean isChinese(String str){
    return str.matches("[\u4E00-\u9FA5]*");
  }
  
  //split
  static void splitStr(){
    String str = "TECH00112/李小双";
    String[] strs = str.split("/");
    for(String s:strs){
      if(isChinese(s))
        System.out.println("name:"+s);
      else
        System.out.println("code:"+s);
    }
  }
  
  //去string中的.000
  static void replaceSpot(){
    String str = "8.000";
    System.out.println("小数："+str.replaceAll("\\.0*$", ""));
  }
  
  static void replaceKuohao(){
    String str = "你好（d)";
    str = str.replaceAll("\\(", "_").replaceAll("\\)", "_").replaceAll("\\（", "_").replaceAll("\\）", "_");
    System.out.println("----"+str);
  }
  
  //比较字符查差值
  static void compareValue(){
    String day1 = "2015-01-09";
    String day2 = "2015-01-09 00:00:00";
    System.out.println("差值："+day2.compareTo(day1));
  }
  
  public static void main(String[] args) {
    replaceKuohao();
    compareValue();
    replaceChinese();
    splitStr();
    replaceSpot();
  }

}
