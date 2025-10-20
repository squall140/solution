package org.ex.interview.multithread.completabefuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * @desc: 核心场景三：聚合多个并行任务（全部完成或任一完成） 并行调用多个外部API，并聚合它们的结果
 * @author: Leif
 * @date: 2025/10/17 10:00
 * <p>
 * 当你需要并行执行多个独立的任务，并在它们都完成后（或其中一个完成后）进行后续处理时，这个功能非常有用。
 *
 * allOf(): 等待所有给定的 CompletableFuture 完成。
 * anyOf(): 等待任意一个给定的 CompletableFuture 完成。
 */
public class CombineTasks {

  public static void main(String[] args) {
    // 模拟三个不同的API调用
    CompletableFuture<String> api1 = CompletableFuture.supplyAsync(() -> callAPI("https://api.users.com", 2000));
    CompletableFuture<String> api2 = CompletableFuture.supplyAsync(() -> callAPI("https://api.products.com",500));
    CompletableFuture<String> api3 = CompletableFuture.supplyAsync(() -> callAPI("https://api.orders.com", 2000));

    // 1. 等待所有任务完成
    CompletableFuture<Void> allFutures = CompletableFuture.allOf(api1, api2, api3);


    // 在所有任务完成后，获取它们的结果
    CompletableFuture<List<String>> allResults = allFutures.thenApply(v ->
      Stream.of(api1, api2, api3)
        .map(CompletableFuture::join) // 在这里调用join是安全的，因为所有future已完成
        .toList()
    );

    allResults.thenAccept(res -> System.out.println("所有API执行结果: " + res));

    // 2. 等待任意一个任务完成
    CompletableFuture<Object> anyFuture = CompletableFuture.anyOf(api1, api2, api3);
    anyFuture.join();  // 等待 anyFuture
    anyFuture.thenAccept(res -> System.out.println("最快的api返回结果: " + res));
  }


  public static String callAPI(String url, int delay) {
    try {
      Thread.sleep(delay);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    return url;

  }

}
