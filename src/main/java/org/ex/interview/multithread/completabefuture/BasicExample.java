package org.ex.interview.multithread.completabefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @desc: 核心场景一：执行耗时任务（避免阻塞主线程）
 * @author: Leif
 * @date: 2025/10/17 09:51
 */
public class BasicExample {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    // 1. 使用 supplyAsync 执行一个有返回值的异步任务
    CompletableFuture<String> future = CompletableFuture.supplyAsync(() ->{
      try{
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      return "[执行结果]";
    });


    // 主线程可以继续做其他事情，不会被阻塞
    System.out.println("主线程可以继续执行...");

    // 2. 阻塞地等待异步任务完成并获取结果（在实际应用中应尽量避免阻塞）
    String result = future.get();
    System.out.println("获取到结果: " + result);

  }
}
