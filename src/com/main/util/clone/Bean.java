package com.main.util.clone;

public class Bean implements Cloneable {
  private String isClone;

  public String getIsClone() {
    return isClone;
  }

  public void setIsClone(String isClone) {
    this.isClone = isClone;
  }
  public String toString(){
    return " "+isClone;
  }
  public Object clone(){
    Object o = null;
    try {
      o = super.clone();
    }catch (CloneNotSupportedException e){
      e.printStackTrace();
    }
    return o;
  }
}
