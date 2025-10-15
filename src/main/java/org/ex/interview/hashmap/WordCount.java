package org.ex.interview.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc: 使用HashMap统计单词出现次数
 * @author: Leif
 * @date: 2025/10/15 15:53
 */
public class WordCount {
  public Map wordCounter(String str){
    Map frequentMap = new HashMap<>();
    String[] chars = str.split("\\W+");

    for(String ch: chars){
      frequentMap.put(ch, frequentMap.getOrDefault(ch, 1));
    }
    return frequentMap;
  }

}
