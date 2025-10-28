package org.ex.leetcode.advance.slidewindow.findallanagramsinastring438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @desc:
 * @author: Leif
 * @date: 2025/10/28 20:27
 */
public class Practice01 {
  public static List<Integer> findAnagrams(String s, String p) {
    List<Integer> res =new ArrayList<>();
    int m = s.length(), n = p.length();
    int[] need = new int[26];
    int[] window = new int[26];

    // 开始初始化need字频数组
    for(int i = 0; i < n; i++){
      need[p.charAt(i) - 'a']++;
    }

    // 准备滑动窗口
    int left = 0, right = 0;
    while( right < m){
      // 开启窗口数据
      window[s.charAt(right) - 'a']++;

      // 当窗口最右端超过p的长度的时候, 当前窗口收缩最左侧,同时向右挪动做指针
      while( right - left + 1 > n ){
        // 在窗口最左侧收缩窗口, 即删除窗口最左侧元素的字频s.charAt(left)
        window[s.charAt(left) - 'a']--;
        left++;
      }

      // 当窗口长度等于数组p的长度n的时候, 进行窗口元素判断
      if (right - left + 1 == n ){
        //开始进行数组对比
        if (Arrays.equals(window, need)) {
          // 如果此时滑动窗口的数组元素和need数组(p数组)元素相同的时候
          // 把左指针left加入到结果集
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
