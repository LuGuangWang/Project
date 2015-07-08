package com.main.util.test;

public class Test{
  Test(){}
  
  
  
  public static void main(String[] args){
    System.out.println("this is my fisrt github source code.");
    MyInterface in = new Interface2();
    in.test();
    
    String a = "A_B_C_D";
    String[] strs = a.split("_");
    for(String str :strs)
    	System.out.println(str);
    
    String time = "2015-01-01";
    if(time.length()>10){
    	time = time.substring(0,10)+" 23:59:59";
    }
    else{
    	time += " 23:59:59";
    }
    int length = time.length();
    System.out.println(time + " " + length);
    
  }
}
