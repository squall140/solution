package org.ex.interview.multithread.completabefuture;

import java.util.concurrent.CompletableFuture;

/**
 * @desc: 核心场景五：结果消费（无需返回值的后续操作）
 * @author: Leif
 * @date: 2025/10/20 09:25
 *
 * 用户注册后发送欢迎邮件
 *
 * thenAccept(): 接收上一个任务的结果，进行消费（无返回值）。
 * thenRun(): 既不接收上一个任务的结果，也不返回任何值，只是在一个任务完成后执行一段代码。
 */
public class Consumer {
  public static void main(String[] args) {
    CompletableFuture.supplyAsync(() ->{
      return registerUser();
    }).thenAccept(newUser ->{
      sendWelcomeEmail(newUser);
      System.out.println("用户注册成功!");
    }).thenRun(() ->{
      System.out.println("日志记录");
    });

}

  private static int sendWelcomeEmail(Object newUser) {
    return 1;
  }

  private static User registerUser() {
    return new User("100",20, "李四");
  }
}
