package org.ex.interview.multithread.futuretask;

import java.sql.Connection;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @desc: 改用ConcurrentHash的情况下，几乎可以避免加锁的操作，性能大大提高，但是在高并发的情况下有可能出现Connection被创建多次的现象.
 * 这时最需要解决的问题就是当key不存在时，创建Connection的动作能放在connectionPool之后执行，
 * 这正是FutureTask发挥作用的时机，基于ConcurrentHashMap和FutureTask的改造,
 * 经过这样的改造，可以避免由于并发带来的多次创建连接及锁的出现。
 * @author: Leif
 * @date: 2025/10/17 09:22
 */
public class ConnectionPoolFutureTask {
  private ConcurrentHashMap<String, FutureTask<Connection>> connectionPool = new ConcurrentHashMap<>();

  public Connection getConnection(String key) throws ExecutionException, InterruptedException {
    FutureTask<Connection> connectionTask = connectionPool.get(key);
    if (connectionTask != null) {
      return connectionTask.get();
    } else {
      Callable<Connection> callable = new Callable<Connection>() {
        @Override
        public Connection call() throws Exception {
          return createConnection();
        }
      };

      FutureTask<Connection> newTask = new FutureTask<>(callable);
       /*
        如果指定的键尚未与值关联(或映射到null),则将其与给定值关联并返回null,否则返回当前值
        返回值: 与指定键关联的上一个值,如果没有键的映射,则为null
        抛出: NullPointerException–如果指定的键或值为null
        */
      connectionTask = connectionPool.putIfAbsent(key, newTask);
      if (connectionTask == null) {
        connectionTask = newTask;
        connectionTask.run();
      }

      return connectionTask.get();

    }
  }

  private Connection createConnection() {
    return null;  // 在这里省略创建Connection的步骤 ..
  }

}
