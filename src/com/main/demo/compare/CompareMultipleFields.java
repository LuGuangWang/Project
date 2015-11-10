package com.main.demo.compare;

public class CompareMultipleFields {

  public static void main(String[] args) {
    ObjectFields o = new ObjectFields();
    o.setAge("");
    o.setName("name1");
    o.setSex("sex");
    System.out.println(o.comparate(new ObjectFields()));
  }

}
