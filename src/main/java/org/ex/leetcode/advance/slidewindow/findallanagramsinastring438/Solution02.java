package org.ex.leetcode.advance.slidewindow.findallanagramsinastring438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @desc: 滑动窗口，更容易理解的做法
 * @author: Leif
 * @date: 2024/2/19 09:09
 */
public class Solution02 {
    public static List<Integer> findAnagrams(String s, String p) {
        int m = s.length(), n = p.length();
        int[] need = new int[26];
        int[] window = new int[26];
        // 初始化need字频计数数组
        for (int i = 0; i < n; i++){
            need[p.charAt(i) - 'a']++;
        }
        List<Integer> res = new ArrayList<>();
        int left = 0, right = 0;
        while ( right < m){
            //加入窗口数据
            window[s.charAt(right) - 'a']++;
            while (right - left + 1 > n){
                window[s.charAt(left) - 'a']--;
                left++;
            }
            // 维护一个长度为 p.length() 的窗口，并更新答案
            if (right - left + 1 == n){
                //开始进行数组比对处理
                if (Arrays.equals(window,need)){
                    res.add(left);
                }
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
