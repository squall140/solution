package org.ex.leetcode.advance.slidewindow.permutationinstring567;

import java.util.Arrays;

/**
 * @desc: Permutation In String
 *
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 * Example 1:
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 *
 * Example 2:
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 *
 * 思路 滑动窗口
 * 写一个函数来判断 s2 是否包含 s1 的排列（是否s1的字母都在s2中的子串中出现）
 *
 * @author: Leif
 * @date: 2024/2/19 09:37
 */
public class Solution {
    public static boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[] need = new int[26];
        int[] window = new int[26];
        for (int i = 0; i < m; i++){
            need[s1.charAt(i) - 'a']++;
        }
        int left = 0, right = 0;
        while (right < n){
            window[s2.charAt(right) - 'a']++;
            while(right - left + 1 > m){
                window[s2.charAt(left) - 'a']--;
                left++;
            }
            if (right - left + 1 == m){
                //s1,s2窗口长度一致的时候进行字频对比
                if(Arrays.equals(window, need)){
                    return true;
                }
            }
            right++;
        }
        return false;

    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
//        String s1 = "ab", s2 = "eidboaoo";
        System.out.println(checkInclusion(s1, s2));
    }


}
