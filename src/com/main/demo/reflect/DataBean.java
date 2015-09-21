package com.main.demo.reflect;

public class DataBean {
  private String code;
  private String name;
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    System.out.println("set value:"+code);
    this.code = code;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
}
