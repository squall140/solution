package org.ex.leetcode.top100.slidingwindow.minwindowsubstring076;

/**
 * @desc: Minimum Window Substring
 *
 * 思路 滑动窗口
 * 仔细体会对比下这道题和438之间的区别
 * 难点在于理解左指针是如何缩减区域以满足最小匹配的字串
 *
 * @author: Leif
 * @date: 2024/3/27 15:13
 */
public class Solution {
    // 发现字符串的题 很多情况都是找子串问题
    // 问题：如何从字符串中找到目标子串
    // 滑动窗口
    // 方法：整型数组存放 Char， Char 的 int 值范围为 0 ~ 127
    // 利用数组 window 存放窗口中字符个数
    // 利用数组 need 存放匹配子串中需要的字符个数
    public static String minWindow(String s, String t) {
        // 如果字符串为空，或者长度小于需要匹配的长度
        if(s.length() == 0 || t.length() == 0 || s.length() < t.length()){
            return "";
        }
        int[] need = new int[128];
        int[] window = new int[128];
        //窗口中已经匹配的字符个数
        int count = 0 ;
        int minLength = t.length();
        int left = 0, right = 0;
        String minString = "";

        // need字频初始化
        for(int i = 0; i < t.length(); i++){
            need[t.charAt(i)]++;
        }

        // 主体部分
        while(right < s.length()){
            char ch = s.charAt(right);
            // window记录字频
            window[ch]++;
            // 如果需要该字符，并且已有窗口内的字符个数小于需要的字符个数
            if(need[ch] > 0 && need[ch] >= window[ch]){
                count++;
            }

            // [重点]当需要的字符全部包含在窗口数组内时，开始收缩left，移动到不满足条件为止
            while(count == t.length()){
                // 拿到此时的左指针字符
                ch = s.charAt(left);
                // 当需要删除的字符，是必须要留在窗口内时
                if (need[ch] > 0 && need[ch] == window[ch]){
                    // 减少统计
                    count--;
                }
                // 开始向右收缩left，直到找到最小包括t的子串
                if (right - left + 1 <= minLength){
                    // 更新最小字串长度为当前窗口长度
                    minLength = right - left + 1;
                    // 拿到最小串
                    minString = s.substring(left, right + 1);
                }
                // 窗口内减少当前字符的字频，
                window[ch]--;
                // 左指针右移
                left++;
            }
            right++;

        }

        return minString;

    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
