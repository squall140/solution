package org.ex.leetcode.array.groupanagrams049;

import java.util.*;

/**
 * @desc: Group Anagrams
 *
 * Given an array of strings strs, group the anagrams together.
 * You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 *
 *  Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 * 思路，HashMap和ArrayList应用题，排序+哈希表
 * map<单词排序后的key, 同一key的的单词集合>，
 * 遍历一次strs即可，不过每个单词仍不可避免要遍历每个字符，  O(n*maxlen*logmaxlen)
 *
 * @author: Leif
 * @date: 2024/3/18 21:58
 */
public class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            // 将每个单词转化为字符数组，排序后得到该单词的key
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String key = new String(chs);
            // Map的key对应是排序后的chs，也就是说相同字母顺序不同的字符串无论它怎么变化，
            // 相同排序算法后，顺序的都是一样的，所以可以确定key
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            // value 就是当前的字符串（可能会有顺序上的颠倒）
            // 举例，key是abc, value就是 cba, cab, bac 等，但key排序后一定是abc
            // 这样就实现了一对多的映射关系
            map.put(key,list);
        }
        List<List<String>> resultList = new ArrayList<>(map.values());
        return resultList;

    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(strs).forEach(System.out::println);
    }

}
