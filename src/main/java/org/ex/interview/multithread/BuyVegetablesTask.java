package org.ex.interview.multithread;

import java.util.concurrent.CountDownLatch;

/**
 * @desc:
 * @author: Leif
 * @date: 2025/10/16 09:43
 */
public class BuyVegetablesTask implements Runnable{
  private CountDownLatch latch;

  public BuyVegetablesTask(CountDownLatch latch){
    this.latch = latch;
  }
  @Override
  public void run() {
    System.out.println("正在买菜...");
    try{
      Thread.sleep(2000);  //买菜模拟2秒
    }catch (InterruptedException e) {
      e.printStackTrace();
    }finally {
      // 每个任务完成后，调用countDown()，计数器减1
      latch.countDown();
    }
    System.out.println("买完菜啦！");
  }
}

