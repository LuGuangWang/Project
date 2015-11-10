package com.main.demo.compare;

public interface Comparator<T> {
  
  default void append(StringBuffer buf,Object fieldValue1,Object fieldValue2){
    buf.append(" jw:").append(fieldValue1).append(" bs:").append(fieldValue2).append(";");
  }
  /**
   * 比对接口
   */
  String comparate(T t);
}
