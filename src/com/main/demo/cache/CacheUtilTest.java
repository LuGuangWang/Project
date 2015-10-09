package com.main.demo.cache;

public class CacheUtilTest {

  public static void main(String[] args) {
    CacheProperty prop = new CacheProperty(100);
    CacheUtil.cache.put("LGTest001", prop);
    System.out.println(CacheUtil.$().getCache("LGTest001"));
  }
}
