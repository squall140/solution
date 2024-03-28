package org.ex.leetcode.top100.slidingwindow.permutationinstring567;

import java.util.Arrays;

/**
 * @desc: Permutation in String
 *
 *
 * @author: Leif
 * @date: 2024/3/28 09:16
 */
public class Solution {
    public static boolean checkInclusion(String s1, String s2) {
        //eidbaooo
        int m = s1.length();
        int n = s2.length();
        int[] need = new int[26];
        int[] window = new int[26];
        int left = 0, right = 0;
        // 初始化need字频
        for (int i = 0; i < m; i++){
            need[s1.charAt(i) - 'a']++;
        }
        // 双指针标准写法
        while(right < n){
            // 统计当前窗口window字频
            window[s2.charAt(right) -'a']++;
            // 当窗口大于s1的长度m时，不断缩小窗口至m，所以这里用 >=m（细节）
            while(right - left + 1 >= m){
                // 当窗口长度等于m ，那么直接做判断
                // 当s1,s2窗口长度一致时（right - left + 1 == m），进行字频对比
                if(Arrays.equals(window, need)){
                    return true;
                }
                // 不断缩小窗口，使得最终窗口和s1的长度一致
                // 两个动作，1.删除最左字符自频 2.向右挪动左指针
                window[s2.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return false;

    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }
}
