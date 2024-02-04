package org.ex.leetcode.advance.slidewindow.longestsubstringwithoutrepeatingcharacters003;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc: Longest Substring Without Repeating Characters
 *
 * Given a String s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 *
 * 思路 滑动窗口
 *
 * 因为是查找满足条件的最长子数组的字符数，主要考虑的是子数组（一段儿区间）的条件匹配度，
 * 这个时候往往使用双指针滑动窗口解法
 *
 * @author: Leif
 * @date: 2024/2/4 21:27
 */
public class Solution {
    public static int lengthOfLongestSubstring(String s){
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        int ans = 0;
        Map<Character,Integer> freq = new HashMap<>();

        for (int j = 0; j < n; j++){
            // 统计字符出现次数
            freq.put(arr[j], freq.getOrDefault(arr[j], 0) + 1);

            // 当某一个字符在map中第二次出现的时候
            while (freq.get(arr[j]) > 1){
                // 发现了重复字符，那么先把第二次出现的字符对应的val减1
                freq.put(arr[i], freq.get(arr[i]) - 1);
                // 挪动i指针
                i++;
            }
            // 当前循环中，所有重复操作都处理完后，累计ans，往复操作
            ans = Math.max(ans, j - i + 1 );
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }



}
