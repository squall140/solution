package org.ex.interview.multithread.completabefuture;

import java.util.concurrent.CompletableFuture;

/**
 * @desc: 核心场景四：异常处理
 * @author: Leif
 * @date: 2025/10/20 09:21
 *
 * exceptionally(): 相当于 catch，允许你捕获异常并返回一个默认值。
 * handle(): 无论成功还是失败都会调用，方法接收结果和异常两个参数，让你可以统一处理。
 */
public class Excpetionally {
  public static void main(String[] args) {
    CompletableFuture.supplyAsync(() -> {
      // 模拟一个可能失败的任务
      if (Math.random() > 0.1) {
        throw new RuntimeException("Oops! Something went wrong!");
      }
      return "Success";
    }).exceptionally(ex ->{
      // 如果发生异常，会进入这里，并提供一个默认值或恢复方案
      System.out.println("处理异常: " + ex.getMessage());
      return "Default Value"; // 从异常中恢复
    }).thenAccept(res -> {
      // 无论成功还是失败（已处理），都会走到这里
      System.out.println("最终结果: " + res);
    });
  }
}
