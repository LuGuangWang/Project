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
  
  public static void main(String[] args) {
    replaceChinese();
    splitStr();
  }

}
