package wlg.javaapi.redis;

import redis.clients.jedis.Jedis;

public class JedisUtil {
  
  private void jedisDemo(){
    Jedis jedis = JedisPoolUtil.getJedis();
    jedis.sadd("lg", "lg1","lg2");
    jedis.del("lg");
    JedisPoolUtil.returnResource(jedis);
  }
  
  public static void main(String[] args) {
    JedisUtil instance = new JedisUtil();
    instance.jedisDemo();
  }
}
