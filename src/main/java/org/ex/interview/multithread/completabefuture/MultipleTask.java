package org.ex.interview.multithread.completabefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @desc: 核心场景二：组合多个异步任务（链式调用）
 * @author: Leif
 * @date: 2025/10/17 09:54
 *
 *
 * thenApply(): 接收上一个任务的结果，进行处理并返回新值（同步操作）。
 * thenCompose(): 接收上一个任务的结果，并返回一个新的 CompletableFuture（用于链接另一个异步任务）。
 */
public class MultipleTask {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    CompletableFuture<String> welcomeTask = CompletableFuture.supplyAsync(() -> {
      try{
        Thread.sleep(500);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      return "123";
    }).thenApply(userId -> {
      // 根据用户id返回信息
      return userId + " 的详细信息";
    }).thenApply(userInfo -> {
      // 组装返回信息
      return "您好, " + userInfo;
    });

    System.out.println(welcomeTask.get());
  }
}
