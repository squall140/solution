package org.ex.interview.volatiles;

/**
 * @desc: 状态标志位, 控制线程的启停
 * @author: Leif
 * @date: 2025/10/16 08:54
 */
public class WorkerThread implements Runnable{
  private volatile boolean isRunning = true;

  @Override
  public void run() {
    while(isRunning){
      // 执行线程业务逻辑
    }
  }

  public void stopWork(){
    this.isRunning = false;
  }
}
