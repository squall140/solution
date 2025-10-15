package org.ex.interview.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @desc:
 * @author: Leif
 * @date: 2025/10/15 12:01
 */
public class ConfigurationCache {
  private static ConcurrentHashMap<String, String> configMap = new ConcurrentHashMap<>();

  public static String getConfig(String key){
    /**
     * ConcurrentHashMap 确保了多个线程可以同时读取和更新配置项，而不会发生数据不一致的问题。
     */
    return configMap.get(key);
  }

  public static int updateConfig(String key, String value){
    try{
      /**
       * ConcurrentHashMap 确保了多个线程可以同时读取和更新配置项，而不会发生数据不一致的问题。
       */
      configMap.put(key, value);
      return 1;
    }catch (Exception e){
      e.printStackTrace();
    }
    return 0;
  }

  public static void initializeDefaults() {
    /**
     * 此外，putIfAbsent 方法确保默认值只在键不存在时才插入，避免了重复更新的问题。
     */
    configMap.putIfAbsent("timeout", "30");
    configMap.putIfAbsent("maxConnections", "100");
  }

}
