package org.ex.interview.multithread;

import java.util.concurrent.CountDownLatch;

/**
 * @desc:
 * @author: Leif
 * @date: 2025/10/16 09:43
 */
public class CookingTask implements Runnable{
  private CountDownLatch latch;

  public CookingTask(CountDownLatch latch){
    this.latch = latch;
  }
  @Override
  public void run() {
    System.out.println("正在做饭...");
    try{
      Thread.sleep(5000);  //买菜模拟5秒
    }catch (InterruptedException e) {
      e.printStackTrace();
    }finally {
      // 每个任务完成后，调用countDown()，计数器减1
      latch.countDown();
    }
    System.out.println("做完饭啦！");
  }
}

