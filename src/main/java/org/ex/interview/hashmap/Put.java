package org.ex.interview.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @desc:
 * @author: Leif
 * @date: 2025/10/15 11:03
 */
public class Put {
  public static void main(String[] args) {
    String javaVersion = System.getProperty("java.version");

    HashMap<String, Integer> map = new HashMap<>(16);
    map.put("zhangsan", 29);
    map.put("lisi", 25);
    map.putIfAbsent("zhangsan", 30);
//    map.put("zhangsan", 30);


    System.out.println(javaVersion);


    List<Map.Entry<String, Integer>> entryList = map.entrySet().stream()
      .filter(entry -> entry.getValue() > 25)
      .filter(entry -> entry.getKey().startsWith("x"))
      .sorted(Map.Entry.comparingByValue()).toList();

    entryList.forEach(System.out::println);


//      .forEach(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));
  }
}
