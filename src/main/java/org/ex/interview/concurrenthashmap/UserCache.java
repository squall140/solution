package org.ex.interview.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @desc:
 * @author: Leif
 * @date: 2025/10/15 11:56
 */
public class UserCache {
  private ConcurrentHashMap<Integer, User> userCache = new ConcurrentHashMap<>();

  public User getUser(int userId){
    /**
     * computeIfAbsent 方法确保了当缓存中没有某个用户时，只有一个线程能够从数据库加载用户信息并更新缓存。
     * 这避免了多个线程同时加载相同用户信息的重复操作，提升了效率。
     */
    return userCache.computeIfAbsent(userId, id -> loadUserFromDatabase(id));
  }

  private User loadUserFromDatabase(int userId) {
    // 模拟数据库查询
    return new User();
  }

}

