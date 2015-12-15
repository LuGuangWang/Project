package com.main.excel.demo;

import com.main.excel.checker.Checker;

public class LTeacherList implements Checker{
  private String teacherCode;
  private String teacherName;
  private String errorMsg;//有用 保存错误信息
  
  public String getErrorMsg() {
    return errorMsg;
  }
  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }
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
