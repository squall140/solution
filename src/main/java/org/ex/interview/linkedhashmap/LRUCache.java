package org.ex.interview.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @desc:
 * @author: Leif
 * @date: 2025/10/15 14:36
 */
public class LRUCache {
  public static void main(String[] args) {
    LRU cache = new LRU(3);
    cache.put("1", "A");
    cache.put("2", "B");
    cache.put("3", "C");
    cache.get("2");  // 访问"1"使其变为最近使用
    cache.put("4", "D");
    System.out.println(cache.get("1"));

  }
}



class LRU extends LinkedHashMap{
  private final int capacity;
  public LRU(int capacity) {
    super(capacity, 0.75f, true);
    this.capacity = capacity;
  }

  @Override
  protected boolean removeEldestEntry(Map.Entry eldest) {
    return size() > capacity; // 超过容量移除最久未使用的
  }

}
