package com.main.demo.string;

public class StringUtil {

  //去除所有非汉字
  static void replaceChinese(){
    String str = "*%hell^你好12）（";
    str = str.replaceAll("[^\u4E00-\u9FA5]", "");
    System.out.print(str);
  }
  
  public static void main(String[] args) {
    replaceChinese();
  }

}
