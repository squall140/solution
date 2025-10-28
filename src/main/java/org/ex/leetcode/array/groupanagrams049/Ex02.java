package org.ex.leetcode.array.groupanagrams049;

import java.util.*;

/**
 *
 * 单词异位
 * 思路，HashMap和ArrayList应用题，排序+哈希表
 * map<单词排序后的key, 同一key的的单词集合>，
 *
 * @author: Leif
 * @date: 2025/10/28 15:30
 */
public class Ex02 {
  public static List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs){
      // 先将当前单词拆成字符数组,并排序
      char[] chs = str.toCharArray();
      Arrays.sort(chs);

      // 转换当前字符数组为心的String,作为map中的key
      String key = new String(chs);

      // 创建单词list, 按照key分组创建, 如果map中存在key值对应的list, 直接取出
      // 如果不存在 key 值对应的list, 则创建一个新的单词分组list
      List<String> list = map.getOrDefault(key, new ArrayList<>());

      // 当前单词加入list
      list.add(str);

      // 当前的list加入map, 实现key和list的映射关系
      map.put(key, list);
    }

    List<List<String>> res = new ArrayList<>(map.values());
    return res;

  }

  public static void main(String[] args) {
    String[] strs = {"eat","tea","tan","ate","nat","bat"};
    groupAnagrams(strs).forEach(System.out::print);
  }
}
