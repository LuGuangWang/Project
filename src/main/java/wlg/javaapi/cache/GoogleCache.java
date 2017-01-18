package wlg.javaapi.cache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class GoogleCache {
  private Logger log = LoggerFactory.getLogger(GoogleCache.class);

  private LoadingCache<String, Object> loadingCache;

  public GoogleCache() {
    loadingCache = CacheBuilder.newBuilder()
                               .maximumSize(300)
                               .expireAfterWrite(1, TimeUnit.DAYS)
                               .build(new CacheLoader<String, Object>() {
                                 @Override
                                 public Object load(String key) throws Exception {
                                   log.info("--------------- adding search cache.");
                                   
                                   return "hello " + key;
                                 }
                               });
  }

  public Object get(String key) {
    log.info("fetch key "+ key);
    try {
      return loadingCache.get(key);
    } catch (ExecutionException e) {
      log.error("fetch from SearcherCache error:", e);
    }
    return null;
  }

  public void put(String key,Object obj) {
    loadingCache.put(key, obj);
  }
  
  public static void main(String[] args) {
    GoogleCache cache = new GoogleCache();
    cache.get("wlg");
    cache.get("wlg");
    cache.get("wlg");
    cache.get("seven");
    
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
    }
    
    cache.get("seven");
  }
}
