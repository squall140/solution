package org.ex.leetcode.top100.slidingwindow.longestsubstringwithoutrepeatingcharacters003;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc: Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 * @author: Leif
 * @date: 2024/3/25 09:50
 */
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (int start =0, end = 0; end < n; end++){
            // 统计字频
            char right = s.charAt(end);
            map.put(right, map.getOrDefault(right, 0) + 1);
            /**
             * 这里比较难理解
             * 借助while循环维护一个条件，只有满足map.get(end) > 1的时候，才退出，
             * 那么意义在于维护一个字符区间[start,end]区间内不允许有重复字符出现，
             * 右指针end每遇到一个重复字符，那么左指针start就从字典中删除一个老字符，使得区间内字符保持唯一
             * 同时向右移动左指针start
             * 用start和end模拟下这个字符串就明白了，abcabcbb
             */
            while(map.get(right) > 1){
                char left = s.charAt(start);
                map.put(left, map.get(left) - 1);
                start++;
            }
            // 不断更新无重复字符区间最大值
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

    }
}
