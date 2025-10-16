package org.ex.interview.volatiles;

/**
 * @desc: 安全的单例模式（双重检查锁定）
 * @author: Leif
 * @date: 2025/10/16 08:35
 */
public class Singleton {
  private static volatile Singleton instance;

  public static Singleton getInstance(){
    if (instance == null ){
      synchronized (Singleton.class){
        if(instance == null){
          instance = new Singleton();
        }
      }
    }

    return instance;
  }

}
