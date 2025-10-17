package org.ex.interview.multithread;

/**
 * @desc:
 * @author: Leif
 * @date: 2025/10/16 09:56
 */
public class CountDownLatch {
  public static void main(String[] args) throws InterruptedException {
    int workerCount = 2;
    java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(workerCount);

    Runnable task1 = new BuyVegetablesTask(latch);
    Runnable task2 = new CookingTask(latch);


    System.out.println("[开始]---主线程等待所有任务完成...");

    // 子线程执行任务4
    new Thread(task2).start();
    new Thread(task1).start();


    // 3. 主线程调用await()，阻塞等待，直到计数器变为0
    latch.await();
    // 4. 所有任务完成后，主线程继续执行
    System.out.println("[结束]---所有任务均已完成...");
  }
}
