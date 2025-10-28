package org.ex.leetcode.advance.slidewindow.findallanagramsinastring438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @desc:
 * @author: Leif
 * @date: 2025/10/28 20:39
 */
public class Practice02 {
  public static List<Integer> findAnagrams(String s, String p) {
    int m = s.length(), n = p.length();
    List<Integer> res = new ArrayList<>();
    if ( m < n ) return res;

    int[] need = new int[26];
    int[] window = new int[26];

    // 首先遍历need数组, 统计need字频
    for(int i = 0; i < n; i++){
      need[p.charAt(i) - 'a']++;
    }

    // 开始滑动窗口
    int left = 0, right = 0;
    while( right < m){
      // 先统计window窗口字频
      window[s.charAt(right) - 'a']++;

      // 当窗口超度超过数组p的长度n的时候, 收缩窗口, 同时左指针向右挪动
      while( right - left + 1 > n){
        window[s.charAt(left) - 'a']--;
        left++;
      }

      // 滑动窗口当长度和数组p的长度相等的时候, 开始比较两个数组
      if( right - left + 1 == n ){
        if (Arrays.equals(window, need)){
          // 如果此时滑动窗口内的数组元素和need(p数组)相同, 那么把左指针的下标加入结果集res
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

