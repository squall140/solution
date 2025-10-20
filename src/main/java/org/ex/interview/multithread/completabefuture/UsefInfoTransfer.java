package org.ex.interview.multithread.completabefuture;

import java.util.concurrent.CompletableFuture;

/**
 * @desc:
 * @author: Leif
 * @date: 2025/10/20 11:12
 */
public class UsefInfoTransfer {
  public static void main(String[] args) {
//    // 1.查询用户信息
//    CompletableFuture<User> userFuture = CompletableFuture.supplyAsync(() ->{
//      try {
//        Thread.sleep(2000);
//      } catch (InterruptedException e) {
//        throw new RuntimeException(e);
//      }
//      return "123";
//    }).thenApply(userId ->{
//      return getUser(userId);
//    });
//    userFuture.thenAccept(user -> System.out.println("得到user 的年龄:" + user.age()));


    // 1. 异步查询用户ID（模拟耗时1秒）
    CompletableFuture<String> userIdFuture = CompletableFuture.supplyAsync(() -> {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return "user_123";  // 假设返回用户ID
    });
    // 2. thenApply链式处理：ID→详情→格式化名称
    CompletableFuture<String> futureChain = userIdFuture.thenApply(userId -> {
      // 第1次转换：ID→用户详情
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return new User(userId, 25, "张三");  // 模拟查询用户详情
    }).thenApply(user -> {
      // 第2次转换：详情→格式化名称
      return user.age() + "岁的" + user.name(); // 输出"25岁的张三"
    });
    // 3. 最终处理结果（非阻塞，任务完成后自动执行）
    futureChain.thenAccept(result -> System.out.println("最终结果：" + result)).join();


  }

  private static User getUser(String userId) {
    return new User(userId, 20, "张三");
  }

}


record User(String id, int age, String name) {
}
