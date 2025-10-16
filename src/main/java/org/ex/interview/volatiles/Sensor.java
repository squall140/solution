package org.ex.interview.volatiles;

/**
 * @desc: 定期"发布"观察结果供程序其他部分使用
 * @author: Leif
 * @date: 2025/10/16 08:41
 */
public class Sensor {
  private volatile double currentTemperature;

  public void updateTemperature(double temperature){
    currentTemperature = temperature;
  }
  public double getCurrentTemperature() {
    return currentTemperature;
  }
}
