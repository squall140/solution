package org.ex.leetcode.top100.slidingwindow.findallanagramsinastring438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @desc: Find All Anagrams in a String
 *
 * 思路，滑动窗口
 *
 * @author: Leif
 * @date: 2024/3/27 14:19
 */
public class Solution {
    public static List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        char[] need = new char[26];
        char[] window = new char[26];
        List<Integer> res = new ArrayList<>();
        // 初始化字符串p中每个字母ascII码，在数组中统计need的字频
        for (int i = 0; i < pLen; i++){
            need[p.charAt(i) - 'a']++;
        }
        int left = 0, right = 0;
        while(right < sLen){
            // window加入right指针的字符不断加入
            // key为字符转换为ASCII的值（实际还是字符）value为出现次数
            window[s.charAt(right) - 'a']++;
            // 如果当前窗口长度和p一致，且当前窗口内的字符和p数组的ascii码一致，视为异位词
            if (right - left + 1 == p.length()){
                if (Arrays.equals(window, need)){
                    res.add(left);
                }
                // 滑动当前窗口，有两个操作
                // 1.左指针该字符ASCII的次数减-，因为要去掉左边的字符
                // 2.左指针右移
                window[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }

        return res;

    }
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s, p));
    }
}
