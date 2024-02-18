package org.ex.leetcode.advance.slidewindow.minimumwindowsubstring076;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc: Minimum Window Substring
 *
 * Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring of s such that every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 * Example 1:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 *
 * Example 2:
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 *
 * Example 3:
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 * 思路 滑动窗口
 *
 *
 * @author: Leif
 * @date: 2024/2/18 10:41
 */
public final class Solution {
    public static String minWindow(String s, String t) {
        int m = s.length();
        int left = 0, right = 0, counter = 0;
        int start = 0, len = Integer.MAX_VALUE;
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        //把t中所有字符全部放到哈希表（字典）中
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        while (right < m){
            char c = s.charAt(right);
            right++;
            // 如果t字典中的字符匹配到了当前右指针所指向的s中的字符
            if(need.containsKey(c)){
                // s的滑动窗口中同时记录这个字符
                window.put(c,window.getOrDefault(c,0) + 1);
                // 如果s的字典中同时包含了这个c，那么直接匹配度+1
                if (window.get(c).equals(need.get(c))){
                    counter++;
                }
            }
            // 当前窗口包括了t的有字符的时候，开始准备缩小窗口
            while (counter == need.size()){
                if (right - left < len){
                    // 重新定义左右指针的起始位置
                    start = left;
                    len = right - left;
                }
                //向左缩进窗口需要被移除的字符
                char removedChar = s.charAt(left);
                //左指针右移，缩小窗口
                left++;
                if (need.containsKey(removedChar)){
                    //如果在需要的字符中 更新window中字符数
                    //如果当前窗口和需要的字符数量一致时，字符种类-1
                    if(window.get(removedChar).equals(need.get(removedChar))){
                        counter--;
                    }
                    window.put(removedChar, window.getOrDefault(removedChar, 0 ) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC" , t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
