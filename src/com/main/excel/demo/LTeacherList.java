package com.main.excel.demo;

import com.main.excel.checker.Checker;

public class LTeacherList implements Checker{
  private String teacherCode;
  private String teacherName;
  
  public String getTeacherCode() {
    return teacherCode;
  }
  public void setTeacherCode(String teacherCode) {
    this.teacherCode = teacherCode;
  }
  public String getTeacherName() {
    return teacherName;
  }
  public void setTeacherName(String teacherName) {
    this.teacherName = teacherName;
  }
  @Override
  public String toCheck() {
    System.out.println("fieldName:"+getTeacherCode());
    return getTeacherCode();
  }
}
