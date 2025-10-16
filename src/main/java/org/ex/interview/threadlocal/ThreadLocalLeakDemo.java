package org.ex.interview.threadlocal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @desc: 内存泄漏重现与解决
 * @author: Leif
 * @date: 2025/10/16 09:11
 *
 * 想象一下ThreadLocal就像是一个"私人储物柜" 🗄️。
 * 每个线程（Thread）都有自己的储物柜，可以往里面存东西，而且只能自己存取，其他线程看不到也拿不到。
 *
 *
 * ThreadLocalMap的 key（弱引用）确实会被回收
 * 但 value（强引用）还在！并且无法通过正常方式访问到（因为key没了）
 * 如果线程一直不终止（比如线程池复用线程），这个value就永远泄漏了
 *
 * 必须在finally中调用remove() 🚨
 * 尽量使用static final修饰ThreadLocal实例 (static保证只有一个ThreadLocal实例,非static时，每次创建新实例都会产生新Entry，增加泄漏风险)
 * 避免存储大对象
 * 线程池环境下要特别小心
 * 考虑使用框架提供的工具类（如Spring的）
 */
public class ThreadLocalLeakDemo {
  static class BigObject {
    byte[] data = new byte[1024 * 1024]; // 1MB
  }

  public static void main(String[] args) throws InterruptedException {
    ThreadPoolExecutor executor = new ThreadPoolExecutor(
      5, 10, 60, TimeUnit.SECONDS,
      new LinkedBlockingQueue<>(10));

    for (int i = 0; i < 50; i++) {
      executor.execute(() -> {
        ThreadLocal tl = new ThreadLocal<>();
        try {
          tl.set(new BigObject());
        }finally {
          tl.remove();
        }
//        tl.remove();
        // 忘记调用tl.remove();
      });
      Thread.sleep(100);
    }

    executor.shutdown();
    System.out.println("finished!");
  }
}
