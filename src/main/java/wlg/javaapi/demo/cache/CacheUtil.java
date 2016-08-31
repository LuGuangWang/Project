package wlg.javaapi.demo.cache;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class CacheUtil {

  private static CacheUtil instance;

  private CacheUtil(){
    
  }
  
  public synchronized static CacheUtil $() {
    if (instance == null) instance = new CacheUtil();
    return instance;
  }

  // 缓存  可想里面put数据 cache.put(appKey, prop);
  public static Cache<String, CacheProperty> cache = CacheBuilder.newBuilder()
                                                                   .maximumSize(1000)
                                                                   .expireAfterAccess(1, TimeUnit.MINUTES)
                                                                   .build();

  public String getCache(String appKey) {
    CacheProperty prop = cache.getIfPresent(appKey);
    if (prop == null) {
      return "0%";
    }
    CacheProperty.SnapShot s = prop.get();
    if (s.isOver()) {
      cache.invalidate(appKey);
      return "100%";
    } else {
      if (s.getTotalCount() <= 0) {
        return "0%";
      }
      return (s.getDoneCount() * 100 / s.getTotalCount()) + "%";
    }
  }
}
