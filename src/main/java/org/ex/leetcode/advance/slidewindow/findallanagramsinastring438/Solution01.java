package org.ex.leetcode.advance.slidewindow.findallanagramsinastring438;

import java.util.*;

/**
 * @desc: Find All Anagrams in a String
 *
 * Given two string s and p, return an array of all the start indices of p's anagrams in s.
 * You may return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Example 1:
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * Example 2:
 *
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 * 思路 滑动窗口 + 字符统计26个字母数组
 *
 * @author: Leif
 * @date: 2024/2/18 20:21
 */
public class Solution01 {
    public static List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        List<Integer> res = new ArrayList<>();
        // 统计字符串p中每个字符出现的次数
        for (int i = 0; i < pLen; ++i) {
            pCount[p.charAt(i) - 'a']++;
        }

        // 初始化左指针位置
        int left = 0;
        // 遍历字符串s的每个字符
        for(int right = 0; right < sLen; right++) {
            // 获取当前字符在26个字母中的位置
            int curRight = s.charAt(right) - 'a';
            // 更新当前窗口中当前字符的频次
            sCount[curRight]++;
            // 如果当前窗口中某个字符的频次超过了p中对应字符的频次，则移动左指针
            while (sCount[curRight] > pCount[curRight]) {
                // 获取左指针位置的字符
                int curLeft = s.charAt(left) - 'a';
                // 更新当前窗口中左指针位置字符的频次
                sCount[curLeft]--;
                // 左指针右移一位
                left++;
            }
            // 如果当前窗口大小等于p的长度，则将左指针位置加入结果列表
            if (right - left + 1 == pLen) {
                res.add(left);
            }
        }

        return res;
    }


    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s, p));
    }
}
