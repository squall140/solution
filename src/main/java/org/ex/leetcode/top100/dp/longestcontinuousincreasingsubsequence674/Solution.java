package org.ex.leetcode.top100.dp.longestcontinuousincreasingsubsequence674;

import java.util.Arrays;

/**
 * @desc: Given an unsorted array of integers nums,
 * return the length of the longest continuous increasing subsequence (i.e. subarray).
 * The subsequence must be strictly increasing.
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5] with length 3.
 * Even though [1,3,5,7] is an increasing subsequence, it is not continuous as elements 5 and 7 are separated by element
 * 4.
 * Example 2:
 *
 * Input: nums = [2,2,2,2,2]
 * Output: 1
 * Explanation: The longest continuous increasing subsequence is [2] with length 1. Note that it must be strictly
 * increasing.
 *
 *
 * @author: Leif
 * @date: 2024/7/5 12:04
 */
public class Solution {
    public static int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if ( n == 1) return 1;
        int res = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i = 1; i < n; i++){
            if(nums[i - 1] < nums[i]){
                dp[i] = Math.max(dp[i - 1] + 1, dp[i]);
            }
            res = Math.max(dp[i], res);
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
//        int[] nums = {2,2,2,2,2};
        System.out.println(findLengthOfLCIS(nums));
    }
}
