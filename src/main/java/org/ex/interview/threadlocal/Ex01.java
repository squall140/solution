package org.ex.interview.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @desc: Threadlocal Test
 *
 * 限制JVM内存测试: -Xms25m -Xmx25m
 *
 * @author: Leif
 * @date: 2025/10/8 14:30
 */


public class Ex01 {
  public static void main(String[] args) {
    ThreadLocal<User> userL = new ThreadLocal<User>();
    ExecutorService executorService = Executors.newFixedThreadPool(30);

    Runtime runtime = Runtime.getRuntime();
    long totalMemory =  runtime.totalMemory(); // 获取JVM初始分配的总内存
//    long freeMemory = runtime.freeMemory(); // 获取当前空闲内存
//    long usedMemory = totalMemory - freeMemory; // 计算已使用内存
//    long maxMemory = runtime.maxMemory(); // 获取JVM允许分配的最大内存

    for(int i = 0; i < 30; i++){
      executorService.execute(() ->{
        // 获取当前空闲内存
        long freeMemory = runtime.freeMemory();
        System.out.println("Free Memory: " + freeMemory / 1024 / 1024 + " MB");
        userL.set(new User(Thread.currentThread().getId()));
        System.out.println("Thread [" + Thread.currentThread().getId() +  "] -> User [ " + userL.get().num + " ]");
        // 每次new User()占用1m内存, 如果不做remove的话, 就会造成内存溢出
//        userL.remove();
      });

      try{
        Thread.sleep(1000);
      }catch(InterruptedException e){
        e.printStackTrace();
      }
    }

    executorService.shutdown();
  }


}


class User {
  public long num = 0;
  public byte[] info = new byte[1024 * 1024];    // 1m

  public User(){ }
  public User(Long num){
    this.num = num;
  }
}
