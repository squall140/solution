package org.ex.leetcode.top100.dp.longestconsecutivesequence128;

import java.util.Arrays;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/7/4 16:53
 */
public class Ex01 {
    public static int longestConsecutive(int[] nums) {
        int n = nums.length;
        if( n == 1) return 1;
        int res = 0;
        int[] dp = new int[n];

        Arrays.fill(dp,1);

        for(int i = 0; i < n; i++){
            for( int j = 0; j < i; j++){
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

            res = Math.max(dp[i], res);
        }

        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {100,4,200,1,3,2};
//        int[] nums = {0,3,7,2,5,8,4,6,0,1};
//        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        int[] nums = {1,3,5,4,7};
        System.out.println(longestConsecutive(nums));
    }
}
