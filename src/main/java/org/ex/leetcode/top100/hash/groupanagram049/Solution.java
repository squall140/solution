package org.ex.leetcode.top100.hash.groupanagram049;

import java.util.*;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/3/24 13:40
 */
public class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        // "eat","tea","tan","ate","nat","bat"
        for (String str : strs){
            // 1.找到每个单个字符串把字符打散
            char[] chs = str.toCharArray();
            // 2.字符按照制定顺序排序
            //   Map的key对应是排序后的chs，也就是说相同字母顺序不同的字符串无论它怎么变化，
            //   相同排序算法后，顺序的都是一样的，所以可以确定key
            Arrays.sort(chs);
            // 3.排序后的字符串作为字典中的key
            String key = new String(chs);
            // 4.查询字典，尝试找到当前乱序的str所对应的key分组，如果找到了就返回那个list
            //   并添加当前str到list中；如果没找到，就新创建一个新的组list，用于存放后续的str作为value
            //   value 就是当前的字符串（可能会有顺序上的颠倒）
            //   举例，key是abc, value就是 cba, cab, bac 等，但key排序后一定是abc
            //   这样就实现了一对多的映射关系
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        List<List<String>> res = new ArrayList<>(map.values());
        return res;
    }
    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams((strs)));

    }
}
