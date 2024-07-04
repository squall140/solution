package org.ex.leetcode.array.groupanagrams049;

import java.util.*;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/7/4 14:44
 */
public class Ex01 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String key = new String(chs);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }

        List<List<String>> res = new ArrayList<>(map.values());
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(strs).forEach(System.out::println);
    }
}
