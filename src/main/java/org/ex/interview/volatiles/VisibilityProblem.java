package org.ex.interview.volatiles;

/**
 * @desc:
 * 每个线程都有自己的工作内存（可以理解为CPU缓存），线程操作变量时通常会先从主内存拷贝到工作内存，修改后再写回主内存。
 * 这就可能导致一个问题：一个线程修改了变量，另一个线程看不到这个修改
 *
 * @author: Leif
 * @date: 2025/10/16 08:25
 */
public class VisibilityProblem {
  private static boolean ready = false;
  private static int number = 0;

  public static void main(String[] args){
    new Thread(() -> {
      while (!ready){
        // 空循环等待
      }
      System.out.println(number);

      number = 42;
      ready = true;
    }).start();
  }


}
