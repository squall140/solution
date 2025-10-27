package org.ex.leetcode.top100.slidingwindow.longestsubstringwithoutrepeatingcharacters003;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc:
 * @author: Leif
 * @date: 2025/10/27 14:41
 */
public class Practice01 {
  public static int lengthOfLongestSubstring(String s) {
    int n = s. length();
    int left =0, right = 0, ans = 0;
    Map<Character,Integer> map = new HashMap<>();
    while (right < n ){
      char curChar = s.charAt(right);
      map.put(curChar, map.getOrDefault(curChar, 0) + 1);
      while(map.get(curChar) > 1 ){
        // 如果在区间内出现了重复字符, 则去掉相应区间内最左侧字符,减少字频,并且挪动指针
        char chRepeat = s.charAt(left);
        map.put(chRepeat, map.get(chRepeat) - 1);
        left++;
      }

      // 不断更新无重复字符区间最大值
      ans = Math.max(ans, right - left + 1);
      right++;

    }

    return ans;

  }

  public static void main(String[] args) {
    String s = "abcdabcdebb";
    System.out.println(lengthOfLongestSubstring(s));

  }
}
