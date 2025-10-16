package org.ex.interview.volatiles;

/**
 * @desc: 读写锁, 计数器
 * volatile 不保证原子性
 *
 * @author: Leif
 * @date: 2025/10/16 08:43
 *
 * 1. volatile能保证原子性吗？
 * 不能！volatile只能保证可见性和有序性，不能保证复合操作的原子性。比如count++这样的操作就不是原子的。
 *
 * 2. volatile和synchronized的区别？
 * 如上表所示，主要区别在作用范围、原子性保证和性能方面。
 *
 * 3. volatile的实现原理？
 * 基于内存屏障和缓存一致性协议，确保可见性和禁止指令重排序。
 *
 * 4. 单例模式中为什么要用volatile？
 * 防止指令重排序导致其他线程获取到未完全初始化的实例。
 *
 * 5. volatile变量和普通变量有什么区别？
 * 主要区别在于：
 * - 可见性保证
 * - 禁止指令重排序
 * - 每次访问都直接读写主内存
 */
public class ReadWriteCounter {
  private volatile int value;

  public synchronized int increment() {
    return value++;
  }

  public int getValue() {
    return value;
  }
}
