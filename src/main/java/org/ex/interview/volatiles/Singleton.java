package org.ex.interview.volatiles;

/**
 * @desc: 安全的单例模式（双重检查锁定） DCL（Double-Checked Locking）
 * 这里volatile防止了指令重排序，确保对象完全初始化后才被引用。
 *
 * @author: Leif
 * @date: 2025/10/16 08:35
 */
public class Singleton {
  private static volatile Singleton instance;

  public static Singleton getInstance(){
    if (instance == null ){  // 第一次检查
      synchronized (Singleton.class){
        if(instance == null){ // 第二次检查
          instance = new Singleton();
        }
      }
    }

    return instance;
  }

}
