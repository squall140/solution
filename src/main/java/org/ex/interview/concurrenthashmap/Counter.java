package org.ex.interview.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @desc:
 *
 * @author: Leif
 * @date: 2025/10/15 11:52
 */
public class Counter {
  private ConcurrentHashMap<String, Integer> counterMap = new ConcurrentHashMap<>();

  // 增加某个操作的计数
  public void increment(String operation){
    /**
     * merge 方法可以确保计数的增加是线程安全的，而不会出现两个线程同时读写导致计数丢失的问题。
     * merge 通过将更新逻辑放入一个原子操作中，避免了手动加锁的麻烦。
     */
    counterMap.merge(operation, 1, Integer::sum);
  }

  // 获取某个操作的计数
  public int getCount(String operation){
    return counterMap.getOrDefault(operation, 0 );
  }
}
