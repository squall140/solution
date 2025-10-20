package org.ex.interview.multithread.futuretask;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Leif
 * @date: 2025/10/17 09:14
 *
 * 例子中，我们通过加锁确保高并发环境下的线程安全，也确保了connection只创建一次，然而确牺牲了性能。
 */
  public class ConnectionPoolProblem {
    private Map<String, Connection> connectionPoolMap = new HashMap<>();
    private ReentrantLock lock = new ReentrantLock();

    public Connection getConnection(String key) {
      lock.lock();
      try {
        if (connectionPoolMap.containsKey(key)) {
          return connectionPoolMap.get(key);
        } else {
          Connection newConnection = createConnection();
          connectionPoolMap.put(key, newConnection);
          return newConnection;
        }
      } finally {
        lock.unlock();
      }
    }

    private Connection createConnection() {
    return null;  // 在这里省略创建Connection的步骤 ...
  }


}
